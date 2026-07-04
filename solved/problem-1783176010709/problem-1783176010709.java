// Last updated: 04/07/2026, 20:10:10
1class Solution {
2    public int maxValidPairSum(int[] nums, int k) {
3        int ans=0;
4        int max=nums[0];
5
6        for(int i=k;i<nums.length;i++){
7            max=Math.max(max,nums[i-k]);
8            ans=Math.max(ans,max+nums[i]);
9        }
10        return ans;
11    }
12}