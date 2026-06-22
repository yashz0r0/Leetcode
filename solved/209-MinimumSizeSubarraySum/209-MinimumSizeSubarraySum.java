// Last updated: 22/06/2026, 23:53:52
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int i=0;
        int n=nums.length;
        int j=0;
        int sum=0;
        int min=Integer.MAX_VALUE;


        while(j<n){
            sum+=nums[j];

            if(sum<target){
                j++;
            }else{  
             while (sum >= target) {
                    min = Math.min(min, j - i + 1);
                    sum -= nums[i];
                    i++;
                }
                j++;
                }
            }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}