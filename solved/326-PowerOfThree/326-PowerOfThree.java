// Last updated: 22/06/2026, 23:53:29
class Solution {
    public boolean isPowerOfThree(int n) {
       if (n == 1) return true;         
        if (n <= 0 || n % 3 != 0) return false;

        return isPowerOfThree(n / 3);

        
    }
}