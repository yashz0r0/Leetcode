// Last updated: 28/07/2026, 08:12:50
1class Solution {
2    public String smallestPalindrome(String s) {
3
4        int[] freq = new int[26];
5
6        for (int i = 0; i < s.length(); i++) {
7            freq[s.charAt(i) - 'a']++;
8        }
9        StringBuilder left = new StringBuilder();
10        char middle = 0;
11
12        for (int i = 0; i < 26; i++) {
13
14            for (int j = 0; j < freq[i] / 2; j++) {
15                left.append((char) (i + 'a'));
16            }
17
18            if (freq[i] % 2 == 1) {
19                middle = (char) (i + 'a');
20            }
21        }
22        String right = new StringBuilder(left).reverse().toString();
23        if (middle != 0) {
24            return left.toString() + middle + right;
25        }
26
27        return left.toString() + right;
28    }
29}