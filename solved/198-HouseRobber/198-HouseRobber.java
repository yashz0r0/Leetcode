// Last updated: 06/07/2026, 16:08:30
1class Solution {
2    public int rob(int[] nums) {
3        int n=nums.length;
4        if(n==1)return nums[0];
5        int[] t=new int[n+1];
6        t[0]=0;
7        t[1]=nums[0];
8
9        for(int i=2;i<=n;i++){
10            t[i]=Math.max(nums[i-1]+t[i-2],t[i-1]);
11        }
12
13        return t[n];
14        
15    }
16}