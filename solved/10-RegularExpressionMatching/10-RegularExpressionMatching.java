// Last updated: 11/07/2026, 00:54:10
1enum Result {
2    TRUE, FALSE
3}
4
5class Solution {
6    Result[][] memo;
7
8    public boolean isMatch(String text, String pattern) {
9        memo = new Result[text.length() + 1][pattern.length() + 1];
10        return dp(0, 0, text, pattern);
11    }
12
13    public boolean dp(int i, int j, String text, String pattern) {
14        if (memo[i][j] != null) {
15            return memo[i][j] == Result.TRUE;
16        }
17        boolean ans;
18        if (j == pattern.length()){
19            ans = i == text.length();
20        } else{
21            boolean first_match = (i < text.length() &&
22                                   (pattern.charAt(j) == text.charAt(i) ||
23                                    pattern.charAt(j) == '.'));
24
25            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
26                ans = (dp(i, j+2, text, pattern) ||
27                       first_match && dp(i+1, j, text, pattern));
28            } else {
29                ans = first_match && dp(i+1, j+1, text, pattern);
30            }
31        }
32        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
33        return ans;
34    }
35}