// Last updated: 22/06/2026, 23:53:05
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zero=0;
        int one=0;
        int max=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)zero++;
            if(nums[i]==1) one++;

            if(zero<=0){
                max=Math.max(max,one);
            }else{
                one=0;
                zero=0;
            }
        }
        return max;
    }
}