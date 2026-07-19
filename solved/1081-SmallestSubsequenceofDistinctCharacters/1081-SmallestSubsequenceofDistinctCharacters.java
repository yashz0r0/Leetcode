// Last updated: 19/07/2026, 19:46:21
1class Solution {
2    public String smallestSubsequence(String s) {
3        int[] freq = new int[26];
4        boolean[] seen = new boolean[26];
5
6        for (char ch : s.toCharArray()) {
7            freq[ch - 'a']++;
8        }
9
10        StringBuilder res = new StringBuilder();
11
12        for (char ch : s.toCharArray()) {
13            freq[ch - 'a']--;
14
15            if (seen[ch - 'a']) continue;
16
17            while (res.length() > 0 &&
18                   res.charAt(res.length() - 1) > ch &&
19                   freq[res.charAt(res.length() - 1) - 'a'] > 0) {
20
21                seen[res.charAt(res.length() - 1) - 'a'] = false;
22                res.deleteCharAt(res.length() - 1);
23            }
24
25            res.append(ch);
26            seen[ch - 'a'] = true;
27        }
28
29        return res.toString();
30    }
31}