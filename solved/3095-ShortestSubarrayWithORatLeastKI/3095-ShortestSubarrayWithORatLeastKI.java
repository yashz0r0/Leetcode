// Last updated: 20/07/2026, 13:03:52
1class Solution {
2    public int minimumSubarrayLength(int[] nums, int k) {
3
4        int n=nums.length;
5            int min=Integer.MAX_VALUE;
6
7
8        for(int i=0;i<n;i++){
9            int or=0;
10            for(int j=i;j<n;j++){
11                or=nums[j]|or;
12                if(or>=k)min=Math.min(min,j-i+1);
13            }
14        }
15
16        return min==Integer.MAX_VALUE?-1:min;
17    }
18}