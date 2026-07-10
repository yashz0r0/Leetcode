// Last updated: 11/07/2026, 01:03:13
1public class Solution {
2public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
3    if (nums == null || nums.length == 0) return false;
4    TreeSet<Long> set = new TreeSet<>();
5    set.add((long) nums[0]);
6    for (int i = 1; i < nums.length; i++) {
7        if (i > k) set.remove((long) nums[i - k - 1]);
8        long left = (long) nums[i] - t;
9        long right = (long) nums[i] + t;
10        if (left <= right && !set.subSet(left, right + 1).isEmpty()) return true;
11        set.add((long) nums[i]);
12    }
13    return false;
14}
15}