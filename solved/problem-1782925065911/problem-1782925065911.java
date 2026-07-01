// Last updated: 01/07/2026, 22:27:45
1class Solution {
2    public int minLengthAfterRemovals(String s) {
3        int a=0;
4        int b=0;
5
6        for(int i=0;i<s.length();i++){
7            if(s.charAt(i)=='a')a++;
8            else b++;
9        }
10
11        return Math.abs(b-a);
12    }
13}