// Last updated: 21/08/2026, 22:44:04
1class Solution {
2    public String modifyString(String s) {
3        char[] arr = s.toCharArray();
4        int n = arr.length;
5
6        for (int i = 0; i < n; i++) {
7            if (arr[i] == '?') {
8
9                for (char ch = 'a'; ch <= 'z'; ch++) {
10                    if (i > 0 && arr[i - 1] == ch) {
11                        continue;
12                    }
13
14                    if (i < n - 1 && arr[i + 1] == ch) {
15                        continue;
16                    }
17
18                    arr[i] = ch;
19                    break;
20                }
21            }
22        }
23
24        return new String(arr);
25    }
26}