// Last updated: 22/06/2026, 23:55:00
class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length-1;
        int k=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]!=val){
            nums[k++]=nums[i];
           }
        }

        return k;
        
    }
}