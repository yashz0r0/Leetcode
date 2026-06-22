// Last updated: 23/06/2026, 00:00:10
class Solution {
    public long maxTotal(int[] nums, String s) {
        int n=nums.length;

        long ans=0;

        int i=0;
        while(i<n){
            if(s.charAt(i)=='0'){
                i++;
                continue;
            }
            int st=i;
            long sum=0;
            int mn=Integer.MAX_VALUE;

            if(st>0){
                sum+=nums[st-1];
                mn=Math.min(mn,nums[st-1]);
            }
            while(i<n&&s.charAt(i)=='1'){
                sum+=nums[i];
                mn=Math.min(mn,nums[i]);
                i++;
            }

            if(st==0){
                ans+=sum;
            }else{
                ans+=sum-mn;
            }
        }

        return ans;
    }
}