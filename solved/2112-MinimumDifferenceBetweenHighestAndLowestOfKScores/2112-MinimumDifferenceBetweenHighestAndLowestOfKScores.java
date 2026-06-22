// Last updated: 23/06/2026, 00:02:25
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0, j=0, n=nums.length;
        int min= Integer.MAX_VALUE;
        while(j<n){
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                min= Math.min( min,nums[j]-nums[i]);
                i++;
                j++;
            }


        }


        return min;
    }
}