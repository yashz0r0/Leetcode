// Last updated: 23/06/2026, 00:01:47
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }

        int[] right = new int[n];
        right[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.abs(left[i] - right[i]);
        }

        return res;
    }
}
