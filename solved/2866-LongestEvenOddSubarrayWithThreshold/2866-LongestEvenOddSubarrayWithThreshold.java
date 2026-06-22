// Last updated: 23/06/2026, 00:01:33
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {

        int n = nums.length;
        int maxLen = 0;
        int i = 0;

        while (i < n) {

            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                i++;
                continue;
            }

            int len = 1;
            int j = i;
            while (j + 1 < n && nums[j + 1] <= threshold && (nums[j] % 2 != nums[j + 1] % 2)) {
                j++;
                len++;
            }

            maxLen = Math.max(maxLen, len);

           
            i = j + 1;
        }

        return maxLen;
        
    }
}