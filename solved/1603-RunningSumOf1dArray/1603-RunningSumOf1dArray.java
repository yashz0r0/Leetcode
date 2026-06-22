// Last updated: 23/06/2026, 00:03:03
class Solution {
    public int[] runningSum(int[] nums) {
        int n= nums.length;

        int pref[]= new int[n];
        pref[0]=nums[0];

        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]+nums[i];
        }

        return pref;
    }
}