// Last updated: 11/07/2026, 01:00:09
1class Solution {
2    public String shortestPalindrome(String s) {
3        int i = 0;
4        int n = s.length();
5        for (int j = 0; j < n; j++) {
6            if (s.charAt(i) == s.charAt(n - j - 1)) {
7                i++;
8            }
9        } 
10        if (i == n) {
11            return s;
12        }
13        String p = new StringBuilder(s.substring(i, n)).reverse().toString();
14        return p + shortestPalindrome(s.substring(0, i)) + s.substring(i);
15    }
16    }