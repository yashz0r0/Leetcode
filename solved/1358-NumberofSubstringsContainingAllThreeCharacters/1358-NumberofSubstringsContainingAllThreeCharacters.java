// Last updated: 30/06/2026, 23:13:54
1class Solution {
2    public int numberOfSubstrings(String s) {
3        int n = s.length();
4
5        int i = 0;
6        int j = 0;
7        Map<Character, Integer> map = new HashMap<>();
8        int cnt = 0;
9
10        while (j < n) {
11
12            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
13
14            while (map.size() == 3) {
15                cnt += n - j;
16
17                char ch = s.charAt(i);
18                map.put(ch, map.get(ch) - 1);
19
20                if (map.get(ch) == 0)
21                    map.remove(ch);
22
23                i++;
24            }
25
26            j++;
27        }
28
29        return cnt;
30    }
31}