// Last updated: 23/06/2026, 00:03:51
class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i])return nums[i];
        }


        return -1;
    }
}