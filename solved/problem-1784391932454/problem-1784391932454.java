// Last updated: 18/07/2026, 21:55:32
1class Solution {
2    public long maximumValue(int n, int s, int m) {
3        if(n==1)return s;
4
5        long ans=s;
6
7          long peaks = n / 2;
8
9        if (peaks > 0) {
10            long cur = (long)s + m + (peaks - 1L) * (m - 1L);
11            ans = Math.max(ans, cur);
12        }
13
14        return ans;
15    }
16}