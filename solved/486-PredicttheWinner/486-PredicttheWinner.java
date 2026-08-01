// Last updated: 01/08/2026, 22:35:13
1class Solution {
2
3    public boolean predictTheWinner(int[] nums) {
4       return solve(nums, 0, nums.length - 1) >= 0;
5    }
6
7    private int solve(int[] nums, int i, int j) {
8
9        if (i == j)
10            return nums[i];
11
12        int left = nums[i] - solve(nums, i + 1, j);
13        int right = nums[j] - solve(nums, i, j - 1);
14
15        return Math.max(left, right);
16    }
17}