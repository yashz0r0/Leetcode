// Last updated: 22/06/2026, 23:58:05
class Solution {
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        int cnt = 0;

        char digit = (char)(x + '0');

        if (s.charAt(0) == digit) return false;

        for (char c : s.toCharArray()) {
            if (c == digit) cnt++;
        }

        return cnt > 0;
    }
}