// Last updated: 22/06/2026, 23:53:03
class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n=nums.length;
        int total=0;
        for(int num:nums){
            total+=num;
        }

        if(Math.abs(target) > total) return 0;

        if((total + target) % 2 != 0) return 0;

        int sum=(total+target)/2;

        int dp[][]= new int[n+1][sum+1];


        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0)dp[i][j]=0;
                if(j==0)dp[i][j]=1;
            }
        }


        for(int i=1;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j]= dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
       return dp[n][sum];
    }
}