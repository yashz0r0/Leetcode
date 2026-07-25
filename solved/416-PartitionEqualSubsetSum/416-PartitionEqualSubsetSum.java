// Last updated: 25/07/2026, 21:50:35
1class Solution {
2    public boolean canPartition(int[] nums) {
3        int n=nums.length;
4        int sum=0;
5        for(int num:nums)sum+=num;
6        if(sum%2!=0)return false;
7        sum/=2;
8
9        boolean[][] t= new boolean[n+1][sum+1];
10        
11        for(int i=0;i<n+1;i++){
12            for(int j=0;j<sum+1;j++){
13                if(i==0)t[i][j]=false;
14                if(j==0)t[i][j]=true;
15            }
16        }
17
18
19        for(int i=1;i<n+1;i++){
20            for(int j=1;j<sum+1;j++){
21                if(nums[i-1]<=j){
22                    t[i][j]=t[i-1][j-nums[i-1]]||t[i-1][j];
23                }else{
24                    t[i][j]=t[i-1][j];
25                }
26            }
27        }
28       
29       return t[n][sum];
30    }
31}