// Last updated: 22/06/2026, 23:54:43
class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if(n<=2)return n;

        int i=2;
        for(int j=2;j<n;j++){
            if(nums[j]!=nums[i-2]){
                nums[i]=nums[j];
                i++;

            }
        }
        return i;
    }
}