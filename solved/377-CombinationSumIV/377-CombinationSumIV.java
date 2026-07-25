// Last updated: 25/07/2026, 13:19:06
1class Solution {
2    Integer[] dp;
3    public int combinationSum4(int[] nums, int target) {
4        dp=new Integer[target+1];
5        return solve(nums, target);
6    }
7
8    private int solve(int[] nums, int target) {
9        if (target == 0) return 1;
10
11        if(dp[target]!=null)return dp[target];
12
13        int ways = 0;
14
15        for (int num : nums) {
16            if (target >= num) {
17                ways += solve(nums, target - num);
18            }
19        }
20
21        return dp[target]=ways;
22    }
23}