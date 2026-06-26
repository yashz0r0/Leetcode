// Last updated: 26/06/2026, 22:45:52
1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int n=nums.length;
4        int ans[]= new int[n];
5        ans[0]=1;
6
7        for(int i=1;i<n;i++){
8            ans[i]=ans[i-1]*nums[i-1];
9        }
10        int right=1;
11        for(int i=n-1;i>=0;i--){
12            ans[i]=ans[i]*right;
13            right*=nums[i];
14        }
15        return ans;
16    }
17}