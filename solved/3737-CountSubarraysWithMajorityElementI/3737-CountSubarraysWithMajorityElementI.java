// Last updated: 25/06/2026, 22:15:46
1class Solution {
2    public int countMajoritySubarrays(int[] nums, int target) {
3        int n = nums.length;
4        int ans = 0;
5
6        for (int l = 0; l < n; l++) {
7            int count = 0;
8            for (int r = l; r < n; r++) {
9                if (nums[r] == target) count++;
10                int len = r - l + 1;
11                if (count > len / 2) ans++;
12            }
13        }
14
15        return ans;
16    }
17}