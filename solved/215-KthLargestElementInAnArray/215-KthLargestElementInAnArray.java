// Last updated: 22/06/2026, 23:53:51
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n= nums.length;

        Arrays.sort(nums);

        return nums[n-k];
        
    }
}