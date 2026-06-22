// Last updated: 22/06/2026, 23:57:57
class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n=nums.length;
        int res[]= new int[nums.length*2];

        for(int i=0;i<n;i++){
            res[i]=nums[i];
            res[i+n]=nums[n-i-1];
        }
       
        return res;

    }
}