// Last updated: 20/07/2026, 19:14:46
1class Solution {
2    class Pair{
3        int val,idx;
4        Pair(int val,int idx){
5            this.val=val;
6            this.idx=idx;
7        }
8    }
9    public int maxSumDistinctTriplet(int[] x, int[] y) {
10        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(b.val,a.val));
11        for(int i=0;i<y.length;i++){
12            pq.add(new Pair(y[i],i));
13        }
14        long sum=0;
15        HashSet<Integer> hs=new HashSet<>();
16        int cnt=0;
17        while(cnt<3 && !pq.isEmpty()){
18            Pair obj=pq.poll();
19            if(!hs.contains(x[obj.idx])){
20                sum+=obj.val;
21                cnt++;
22                hs.add((x[obj.idx]));
23            }
24        }
25        return cnt==3?(int)sum:-1;
26    }
27}