// Last updated: 23/06/2026, 00:03:14
class Solution {
    public int maxScore(int[] nums, int k) {
        int n= nums.length;
        int i=0;
        int j=0;
        int k1= n-k;
        int total=0;
        for(int x:nums)total+=x;
        if(k==n) return total;
        int sum=0;
        int max=0;
        while(j<n){
            sum+= nums[j];
            if(j-i+1<k1){
                j++;
            }else if(j-i+1==k1){
                max= Math.max(max, total-sum);
                sum-=nums[i];
                i++;
                j++;
            }

        }

        return max;
    }
}