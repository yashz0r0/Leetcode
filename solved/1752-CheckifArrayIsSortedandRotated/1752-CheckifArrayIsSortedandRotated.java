// Last updated: 17/09/2026, 20:46:18
1class Solution {
2    public boolean check(int[] nums) {
3
4        int n = nums.length;
5        int count = 0;
6
7        for(int i = 0; i < n; i++){
8            if(nums[i] > nums[(i+1)%n]){
9                count++;
10            }
11        }
12
13        return count <= 1;
14    }
15}