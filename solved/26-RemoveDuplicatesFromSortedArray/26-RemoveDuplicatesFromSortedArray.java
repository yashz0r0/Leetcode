// Last updated: 22/06/2026, 23:55:01
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        if(nums.length==0 ) return 0;

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }

        return i+1;
        
    }
}