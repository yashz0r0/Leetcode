// Last updated: 23/06/2026, 00:01:51
class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int g = 0;
            for (int j = i; j < n; j++) {
                g = gcd(g, nums[j]);

                if (g == k) {
                    count++;
                } else if (g < k) {
                    break;
                }
            }
        }
        return count;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
