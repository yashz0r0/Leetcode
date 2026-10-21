// Last updated: 21/10/2026, 22:19:38
1import java.util.*;
2
3class Solution {
4    public int minOperations(String s) {
5        char[] sorted = s.toCharArray();
6        Arrays.sort(sorted);
7
8        if (s.equals(new String(sorted))) return 0;
9
10        int n = s.length();
11
12        if (n == 2 && s.charAt(0) > s.charAt(1)) return -1;
13
14        if (s.charAt(0) == sorted[0] || s.charAt(n - 1) == sorted[n - 1])
15            return 1;
16
17        char mn = sorted[0];
18        char mx = sorted[n - 1];
19
20        boolean mnPrefix = false, mxSuffix = false;
21
22        for (int i = 0; i < n - 1; i++)
23            if (s.charAt(i) == mn) mnPrefix = true;
24
25        for (int i = 1; i < n; i++)
26            if (s.charAt(i) == mx) mxSuffix = true;
27
28        if (!mnPrefix && !mxSuffix) return 3;
29
30        return 2;
31    }
32}