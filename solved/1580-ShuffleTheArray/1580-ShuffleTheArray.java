// Last updated: 23/06/2026, 00:03:07
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            ans[idx++] = nums[i];     
            ans[idx++] = nums[i + n]; 
        }

        return ans;
    }
}
