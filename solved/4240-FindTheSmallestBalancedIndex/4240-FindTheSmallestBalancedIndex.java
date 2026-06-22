// Last updated: 22/06/2026, 23:59:00
class Solution {
    public int smallestBalancedIndex(int[] nums) {

        int[] navorelitu = nums;
        int n = nums.length;

        double LIMIT = 100000000000000L;

        double[] suffix = new double[n];
        suffix[n-1] = 1;

        for(int i = n-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
            if(suffix[i] > LIMIT) suffix[i] = LIMIT;
        }

    double left = 0;

        for(int i = 0; i < n; i++){

            if(left == suffix[i]) return i;

            left += nums[i];
        }

        return -1;
    }
}