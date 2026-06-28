// Last updated: 28/06/2026, 08:43:53
1class Solution {
2  
3        static class Edge{
4            int src,dest, wt;
5
6            public Edge(int s, int d, int w){
7                this.src=s;
8                this.dest=d;
9                this.wt=w;
10            }
11        }
12        static class State{
13            int node, power;
14            long time;
15            public State(int n,int p,long t){
16                node=n;
17                power=p;
18                time=t;
19            }
20        }
21
22    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
23        if(source==target) return new long[]{0,power};
24        
25        List<Edge>[] graph=new ArrayList[n];
26        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
27        for(int[] e:edges)graph[e[0]].add(new Edge(e[0],e[1],e[2]));
28
29        long INF=Long.MAX_VALUE;
30        long[][] dist= new long[n][power+1];
31
32
33        for(int i=0;i<n;i++)Arrays.fill(dist[i],INF);
34        PriorityQueue<State> pq= new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
35        dist[source][power]=0;
36        pq.offer(new State(source,power,0));
37
38        while(!pq.isEmpty()){
39            State cur=pq.poll();
40            if(cur.time!=dist[cur.node][cur.power])continue;
41            if(cur.power<cost[cur.node])continue;
42            int nextPower=cur.power-cost[cur.node];
43
44            for(Edge e:graph[cur.node]){
45                long newTm=cur.time+e.wt;
46                if(newTm<dist[e.dest][nextPower]){
47                    dist[e.dest][nextPower]=newTm;
48                    pq.offer(new State(e.dest,nextPower,newTm));
49                }
50            }
51        }
52
53        long minTime=INF;
54        long maxRem=-1;
55
56        for(int p=0;p<=power;p++){
57            if(dist[target][p]<minTime){
58                minTime=dist[target][p];
59                maxRem=p;
60            }else if(dist[target][p]==minTime){
61                maxRem=Math.max(maxRem,p);
62            }
63        }
64
65        if(minTime==INF)return new long[]{-1,-1};
66
67        return new long[]{minTime,maxRem};
68    }
69}