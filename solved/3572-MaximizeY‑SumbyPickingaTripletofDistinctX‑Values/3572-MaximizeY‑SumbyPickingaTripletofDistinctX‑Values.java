// Last updated: 20/07/2026, 19:19:58
1class Solution {
2    class Pair{
3        int y,x;
4        Pair(int y,int x){
5            this.y=y;
6            this.x=x;
7        }
8    }
9    public int maxSumDistinctTriplet(int[] x, int[] y) {
10        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(b.y,a.y));
11        for(int i=0;i<y.length;i++){
12            pq.add(new Pair(y[i],x[i]));
13        }
14        long sum=0;
15        HashSet<Integer> hs=new HashSet<>();
16        int cnt=0;
17        while(cnt<3 && !pq.isEmpty()){
18            Pair obj=pq.poll();
19            if(!hs.contains(obj.x)){
20                sum+=obj.y;
21                cnt++;
22                hs.add(obj.x);
23            }
24        }
25        return cnt==3?(int)sum:-1;
26    }
27}