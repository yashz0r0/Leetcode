// Last updated: 07/08/2026, 21:25:44
1public class Solution {
2    public String longestPalindrome(String s) {
3        if (s.length() <= 1) {
4            return s;
5        }
6
7        int maxLen = 1;
8        String maxStr = s.substring(0, 1);
9
10        for (int i = 0; i < s.length(); i++) {
11            for (int j = i + maxLen; j <= s.length(); j++) {
12                if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
13                    maxLen = j - i;
14                    maxStr = s.substring(i, j);
15                }
16            }
17        }
18
19        return maxStr;
20    }
21
22    private boolean isPalindrome(String str) {
23        int left = 0;
24        int right = str.length() - 1;
25
26        while (left < right) {
27            if (str.charAt(left) != str.charAt(right)) {
28                return false;
29            }
30            left++;
31            right--;
32        }
33
34        return true;
35    }
36}