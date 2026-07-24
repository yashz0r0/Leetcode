// Last updated: 24/07/2026, 21:43:51
1class Solution {
2    public int minTaps(int n, int[] ranges) {
3        int[] maxran= new int[n + 1];
4
5        for (int i = 0; i <= n; i++) {
6            int left = Math.max(0, i - ranges[i]);
7            int right = Math.min(n, i + ranges[i]);
8            maxran[left] = Math.max(maxran[left], right);
9        }
10
11        int tap=0;
12        int curr=0;
13        int max=0;
14
15        for(int i=0;i<=n;i++){
16            if(i>max)return -1;
17            if(i>curr){
18                curr=max;
19                tap++;
20            }
21            max=Math.max(max,maxran[i]);
22        }
23        return tap;
24    }
25}