// Last updated: 23/06/2026, 00:02:34
class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length;

        Arrays.sort(nums);

        int i=0;
        int j=n-1;
        int pair=0;

        while(j>i){
            pair= Math.max(pair, nums[i]+nums[j]);

            i++;
            j--;
        }
        return pair;
    }
}