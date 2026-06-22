// Last updated: 23/06/2026, 00:01:31
class Solution {
    public long maximumTripletValue(int[] nums) {
          int n = nums.length;

        // Step 1: suffix max array
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        // Step 2: iterate j as middle
        long ans = 0;
        int maxLeft = nums[0];

        for (int j = 1; j < n - 1; j++) {
            long value = (long)(maxLeft - nums[j]) * maxRight[j + 1];
            ans = Math.max(ans, value);
            maxLeft = Math.max(maxLeft, nums[j]);
        }

        return ans;
        
    }
}