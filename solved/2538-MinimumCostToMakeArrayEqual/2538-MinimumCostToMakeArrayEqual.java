// Last updated: 23/06/2026, 00:01:53
class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;

        // pair nums and cost
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }

        // sort by nums
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // total weight
        long totalWeight = 0;
        for (int i = 0; i < n; i++) {
            totalWeight += arr[i][1];
        }

        // find weighted median -> this fixes fi
        long prefix = 0;
        int fi = 0;
        for (int i = 0; i < n; i++) {
            prefix += arr[i][1];
            if (prefix * 2 >= totalWeight) {
                fi = arr[i][0];
                break;
            }
        }

        // compute total cost (your logic, correct)
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += (long) Math.abs(nums[i] - fi) * cost[i];
        }

        return total;
    }
}
