// Last updated: 22/06/2026, 23:58:29
class Solution {
    public long minOperations(int[] nums) {
        int n=nums.length;
        long cost=0;

        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                cost+=(nums[i-1]-nums[i]);
            }
        }
        return cost;
    }
}