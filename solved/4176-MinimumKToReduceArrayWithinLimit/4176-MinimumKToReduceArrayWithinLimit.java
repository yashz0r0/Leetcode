// Last updated: 22/06/2026, 23:59:38
class Solution {
    public int minimumK(int[] nums) {

        

        int n = nums.length;
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int left = 1;
        int right = Math.max(max, n);
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long ops = 0;

            for (int x : nums) {
                ops += (x + mid - 1) / mid;
                if (ops > (long) mid * mid) break;
            }

            if (ops <= (long) mid * mid) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
