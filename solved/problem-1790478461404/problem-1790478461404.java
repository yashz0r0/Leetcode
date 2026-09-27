// Last updated: 27/09/2026, 08:37:41
1class Solution {
2    public long maxEarnings(int[][] meetings) {
3        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
4        PriorityQueue<long[]> pq= new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
5        long maxval=Long.MIN_VALUE;
6        long maxearning=0;
7
8        for(int[] m:meetings){
9            long st= m[0];
10            long end=m[1];
11            long rev= m[2];
12
13            while(!pq.isEmpty() && pq.peek()[0]<=st){
14                long[] popped= pq.poll();
15                if(popped[1]>maxval){
16                    maxval=popped[1];
17                }
18            }
19
20            long curr=rev;
21            if(maxval!=Long.MIN_VALUE){
22                curr=Math.max(curr,rev+st+maxval);
23            }
24            if(curr>maxearning)maxearning=curr;
25            pq.offer(new long[]{end,curr-end});
26        }
27
28        return maxearning;
29    }
30}