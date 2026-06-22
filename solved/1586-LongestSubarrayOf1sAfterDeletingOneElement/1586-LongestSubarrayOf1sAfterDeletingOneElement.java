// Last updated: 23/06/2026, 00:03:06
class Solution {
    public int longestSubarray(int[] nums) {
        
        int i=0;
        int j=0;
        int n=nums.length;
        int zero=0;
        int max= 0;
        while(j<n){
            if(nums[j]==0)zero++;

            while(zero>1){
                if(nums[i]==0)zero--;
                i++;
            }
            

           max= Math.max(max,j-i);
           j++;
        }

        return max;
    }
}