// Last updated: 22/06/2026, 23:53:22
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) if (set1.contains(num)) resultSet.add(num);
        int[] res = new int[resultSet.size()];
        int index = 0;
        for (int value : resultSet) res[index++] = value;
        return res;
    }
}