// Last updated: 22/06/2026, 23:57:47
class Solution {
     public boolean isValid(long sum, int x){
            if(sum<0) sum=-sum;
            int lastdig = (int) (sum%10);
            if(lastdig != x) return false;
            while(sum>=10){
                sum/=10;
            }
            return sum==x;
        }

    public int countValidSubarrays(int[] nums, int x) {
         int n = nums.length;
        long [] prefix = new long[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        int res=0;
        for(int i =0;i<n;i++){
            for(int j=i;j<n;j++){
                long sum = prefix[j+1]-prefix[i];
                if(isValid(sum,x))res++;
            }
        }
        return res;
    }
}