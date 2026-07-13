// Last updated: 13/07/2026, 08:02:01
1class Solution {
2    public int findMin(int[] nums) {
3        return Arrays.stream(nums).min().getAsInt();
4    }
5}