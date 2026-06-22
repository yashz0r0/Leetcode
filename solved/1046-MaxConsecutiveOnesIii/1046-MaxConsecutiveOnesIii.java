// Last updated: 23/06/2026, 00:03:46
class Solution {
    public int longestOnes(int[] nums, int k) {

        int j=0;
        int n=nums.length;
        int i=0;
        int zero=0;
        int one=0;
        int max=0;
         while (j < n) {

            if (nums[j] == 0) {
                zero++;
            }

            while (zero > k) {
                if (nums[i] == 0) {
                    zero--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
        
    }
}