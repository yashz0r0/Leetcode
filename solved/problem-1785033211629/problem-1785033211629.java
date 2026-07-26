// Last updated: 26/07/2026, 08:03:31
1class Solution {
2    public int largestInteger(int n, int s) {
3        if(s>9*n)return -1;
4        if(s==0)return 0;
5        StringBuilder ans= new StringBuilder();
6        for(int i=0;i<n;i++){
7            int dig=Math.min(9,s);
8            ans.append(dig);
9            s-=dig;
10        }
11        return Integer.parseInt(ans.toString());
12    }
13}