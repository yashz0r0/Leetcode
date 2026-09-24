// Last updated: 24/09/2026, 22:18:35
1class Solution {
2    public int smallestIndex(int[] nums) {
3        for (int i = 0; i < nums.length; i++) {
4            int sum = 0;
5            String s = String.valueOf(nums[i]);
6            for (char c : s.toCharArray()) {
7                sum += (c - '0'); 
8            }
9            
10           
11            if (sum == i) {
12                return i;
13            }
14        }
15        return -1;
16    }
17}