// Last updated: 22/06/2026, 23:54:01
class Solution {
    public void rotate(int[] nums, int k) {
         int n=nums.length;
        if(n<k){
            k=k%n;
        }
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public void reverse(int[] nums,int s,int e){
        while(s<e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;e--;
        }
    }
}