// Last updated: 23/06/2026, 00:02:47
class Solution {
    public boolean check(int[] nums) {

        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] > nums[(i+1)%n]){
                count++;
            }
        }

        return count <= 1;
    }
}