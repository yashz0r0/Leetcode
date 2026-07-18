// Last updated: 18/07/2026, 19:13:38
1class Solution {
2    public int findGCD(int[] nums) {
3
4        Arrays.sort(nums);
5
6        return gcd(nums[0],nums[nums.length-1]);
7        
8    }
9
10    private int gcd(int a, int b){
11        if(b==0) return a;
12
13        return gcd(b, a%b);
14    }
15}