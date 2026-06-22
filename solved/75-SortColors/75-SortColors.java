// Last updated: 22/06/2026, 23:54:45
class Solution {
    public void sortColors(int[] nums) {
      int i=0;
       int j=nums.length-1;

       while(i<j){
        if(nums[j]==0&& nums[i]!=0){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;

            i++;
            j--;
        }else if(nums[i]==0)i++;
        else if(nums[j]!=0)j--;
        
       }

       i=0;
       j=nums.length-1;

       for( i=1;i<nums.length;i++){
         if(nums[i-1]==0&&nums[i]!=0)break;
       }

       if(nums[0]!=0)i=0;

       while(i<j){
        if(nums[j]==1&& nums[i]!=1){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;

            i++;
            j--;
        }else if(nums[i]==1)i++;
        else if(nums[j]!=1)j--;
        
       }
       
    }
}