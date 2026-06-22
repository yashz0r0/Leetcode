// Last updated: 22/06/2026, 23:53:37
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++)if(nums[i] != i) return i;
        return nums.length; 
    }
}