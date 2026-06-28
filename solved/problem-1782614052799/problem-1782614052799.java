// Last updated: 28/06/2026, 08:04:12
1class Solution {
2    public long maxSum(int[] nums, int k, int mul) {
3        Arrays.sort(nums);
4
5        long ans=0;
6        for(int i=0;i<k;i++){
7            long x=nums[nums.length-1-i];
8            long coef=Math.max(1L,(long)mul-i);
9            ans+=x*coef;
10        }
11
12        return ans;
13    }
14}