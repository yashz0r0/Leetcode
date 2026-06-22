// Last updated: 22/06/2026, 23:54:56
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int r=n-1;

        while(l<=r){
            int mid= l+(r-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target)l=mid+1;
            else r=mid-1;
        }

        return l;
    }
}