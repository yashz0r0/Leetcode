// Last updated: 22/06/2026, 23:59:43
class Solution {
    public long maximumScore(int[] nums) {
        int n=nums.length;

        long[] suff= new long[n];
        suff[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]= Math.min(nums[i],suff[i+1]);
        }
        long prefix[]=new long[n+1];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]= nums[i]+prefix[i-1];
        }

        long ans= Long.MIN_VALUE;

        for(int i=0;i<n-1;i++){
            ans= Math.max(ans, prefix[i]-suff[i+1]);
        }


        return ans;
        
        
    }
}