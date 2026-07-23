// Last updated: 23/07/2026, 22:41:01
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length;
4
5        if (n <= 2) return n;
6
7        int mask = 0;
8        for (int num : nums) {
9            mask |= num;
10        }
11
12        return mask + 1;
13    }
14}