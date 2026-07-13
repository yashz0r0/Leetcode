// Last updated: 13/07/2026, 22:57:26
1class Solution {
2    public int poorPigs(int b, int m, int n) {
3        int c=0;
4        while(Math.pow(n/m+1,c)<b)
5        {
6            c++;
7        }
8        return c;
9    }
10}