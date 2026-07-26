// Last updated: 26/07/2026, 19:52:01
1class Solution {
2    public boolean isPowerOfTwo(int n) {
3        
4        return n>0&&(n&(n-1))==0;    
5    }
6}