// Last updated: 22/06/2026, 23:55:09
class Solution {
    public int maxArea(int[] height) {

        int water = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            int ht = Math.min(height[i], height[j]);
            int width = j - i;
            water = Math.max(water, ht * width);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return water;
    }
}
