// Last updated: 22/06/2026, 23:53:26
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 1) return true;         
        if (n <= 0 || n % 4 != 0) return false;

        return isPowerOfFour(n / 4);
        
    }
}