// Last updated: 22/06/2026, 23:55:52
class Solution {
    public int pivotIndex(int[] nums) {
        int n= nums.length;
        int total=0;
        int sum=0;

        for(int x:nums)total+=x;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==(total-(sum-nums[i]))) return i;
        }
        return -1;
    }
}