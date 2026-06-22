// Last updated: 22/06/2026, 23:54:53
class Solution {
    public int maxSubArray(int[] nums) {
        int curr=nums[0];
        int n=nums.length;
        int max=nums[0];
        for(int i=1;i<n;i++){
           curr=Math.max(nums[i],curr+nums[i]);

            max=Math.max(max,curr);
        }
        return max;
    }
}