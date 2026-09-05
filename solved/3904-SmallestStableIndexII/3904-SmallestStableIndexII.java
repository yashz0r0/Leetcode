// Last updated: 05/09/2026, 22:56:56
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3         int n=nums.length;
4        int[] pref= new int[n];//max
5        int[] suff=new int[n];//min
6
7        pref[0]=nums[0];
8        for(int i=1;i<n;i++)pref[i]=Math.max(pref[i-1],nums[i]);
9        suff[n-1]=nums[n-1];
10        for(int i=n-2;i>=0;i--)suff[i]=Math.min(suff[i+1],nums[i]);
11        for(int i=0;i<n;i++){
12            if(pref[i]-suff[i] <=k)return i;
13        }
14
15        return -1;
16    }
17}