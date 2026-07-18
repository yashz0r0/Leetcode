// Last updated: 18/07/2026, 19:16:15
1class Solution {
2    public int findGCD(int[] nums) {
3        int min=Arrays.stream(nums).min().getAsInt();
4        int max=Arrays.stream(nums).max().getAsInt();
5        return gcd(min,max);
6        
7    }
8
9    private int gcd(int a, int b){
10        if(b==0) return a;
11
12        return gcd(b, a%b);
13    }
14}