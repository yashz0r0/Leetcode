// Last updated: 26/06/2026, 14:47:41
1class Solution {
2    public int pivotIndex(int[] nums) {
3       int total=Arrays.stream(nums).sum();
4       int sum=0;
5       for(int i=0;i<nums.length;i++){
6         sum+=nums[i];
7        if(sum==(total-sum+nums[i]))return i;
8         
9       }
10
11       return -1;
12    }
13}