// Last updated: 03/09/2026, 19:01:28
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int min=Integer.MAX_VALUE;
4        boolean alleven=true;
5        for(int x:nums1){
6            min=Math.min(min,x);
7            if(x%2!=0){
8                alleven=false;
9            }
10        }
11        if(alleven)return true;
12        return min%2==1;
13    }
14}