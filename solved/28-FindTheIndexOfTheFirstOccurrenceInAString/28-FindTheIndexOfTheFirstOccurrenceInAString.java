// Last updated: 22/06/2026, 23:54:58
class Solution {
    public int strStr(String s1, String s2) {

        if (s2.length() == 0) return 0;

        int i = 0;
        int j = s1.length();

        while (i <= j - s2.length()) {
            int cnt = 0;

            while (cnt < s2.length() &&
                   s1.charAt(i + cnt) == s2.charAt(cnt)) {
                cnt++;
            }

            if (cnt == s2.length()) {
                return i;
            }

            i++;
        }

        return -1;
    }
}
