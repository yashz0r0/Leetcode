// Last updated: 22/06/2026, 23:54:05
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int l = i + 1;
            int r = n - 1;
            int rem = target - nums[i];

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (nums[mid] == rem) {
                    return new int[]{i+1, mid+1};
                } else if (nums[mid] < rem) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
