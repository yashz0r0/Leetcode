// Last updated: 22/06/2026, 23:53:43
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1)return true;
        if(n==0||n%2!=0)return false;

        return isPowerOfTwo((n)/2);
        
    }
}