// Last updated: 04/10/2026, 08:26:00
1class Solution {
2    public long maxAlternatingSum(int[] nums) {
3        long dp0pos=Long.MIN_VALUE/2;
4        long dp0neg=Long.MIN_VALUE/2;
5        long dp1pos=Long.MIN_VALUE/2;
6        long dp1neg=Long.MIN_VALUE/2;
7
8        long prev_dp0pos=Long.MIN_VALUE/2;;
9        long prev_dp0neg=Long.MIN_VALUE/2;
10        long ans=Long.MIN_VALUE/2;
11
12        for(int x:nums){
13            long nextdp1pos=Math.max(dp1neg+x,prev_dp0neg+x);
14            long nextdp1neg=Math.max(dp1pos-x,prev_dp0pos-x);
15            
16            long nextdp0pos=Math.max((long)x,dp0neg+x);
17            long nextdp0neg=dp0pos-x;
18
19            prev_dp0pos=dp0pos;
20            prev_dp0neg=dp0neg;
21            dp0pos=nextdp0pos;
22            dp0neg=nextdp0neg;
23            dp1pos=nextdp1pos;
24            dp1neg=nextdp1neg;
25
26            ans=Math.max(ans,Math.max(Math.max(dp0pos,dp0neg),Math.max(dp1pos,dp1neg)));
27        }
28
29        return ans;
30    }
31}