// Last updated: 22/06/2026, 23:59:19
class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int start= n-1;

        while(start>0&&nums[start-1]<nums[start]) start--;

        return start;
       
    }
}
