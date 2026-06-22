// Last updated: 23/06/2026, 00:00:56
class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean allZero = true;
        
        for (int num : nums) {
            xor ^= num;
            if (num != 0) allZero = false;
        }
        
        if (xor != 0) return nums.length;
        
        return allZero ? 0 : nums.length - 1;
    }
}