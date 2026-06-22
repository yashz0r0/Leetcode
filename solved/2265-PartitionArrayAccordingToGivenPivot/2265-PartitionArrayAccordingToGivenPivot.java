// Last updated: 23/06/2026, 00:02:09
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        int[] result = new int[nums.length];
        int idx = 0;

        for (int x : less) result[idx++] = x;
        for (int x : equal) result[idx++] = x;
        for (int x : greater) result[idx++] = x;

        return result;
    }
}
