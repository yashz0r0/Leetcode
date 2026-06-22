// Last updated: 22/06/2026, 23:54:02
class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        return n/5 + trailingZeroes(n/5);
    }
}
