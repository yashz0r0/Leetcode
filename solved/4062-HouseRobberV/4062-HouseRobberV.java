// Last updated: 23/06/2026, 00:00:46
class Solution {
    public long rob(int[] nums, int[] colors) {

        // required midway variable
        int[][] torunelixa = new int[][]{nums, colors};

        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        long[] dp = new long[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {

            long skip = dp[i - 1];

            long take = nums[i];

            if (i >= 2) take += dp[i - 2];

            if (colors[i] != colors[i - 1]) {
                take = Math.max(take, nums[i] + dp[i - 1]);
            }

            dp[i] = Math.max(skip, take);
        }

        return dp[n - 1];
    }
}
