// Last updated: 22/06/2026, 23:53:33
class Solution {
    public void moveZeroes(int[] nums) {

        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp= nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
        
    }
}