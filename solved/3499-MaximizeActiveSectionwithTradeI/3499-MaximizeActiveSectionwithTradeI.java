// Last updated: 21/07/2026, 07:54:37
1class Solution {
2    public int maxActiveSectionsAfterTrade(String s) {
3        String t = "1" + s + "1";
4
5        ArrayList<Character> ch = new ArrayList<>();
6        ArrayList<Integer> len = new ArrayList<>();
7
8        int cnt = 1;
9        for (int i = 1; i < t.length(); i++) {
10            if (t.charAt(i) == t.charAt(i - 1)) {
11                cnt++;
12            } else {
13                ch.add(t.charAt(i - 1));
14                len.add(cnt);
15                cnt = 1;
16            }
17        }
18        ch.add(t.charAt(t.length() - 1));
19        len.add(cnt);
20
21        int ones = 0;
22        for (char c : s.toCharArray()) {
23            if (c == '1') ones++;
24        }
25
26        int gain = 0;
27
28        for (int i = 1; i < ch.size() - 1; i++) {
29            if (ch.get(i) == '1' &&ch.get(i - 1) == '0' &&ch.get(i + 1) == '0') {
30                gain = Math.max(gain, len.get(i - 1) + len.get(i + 1));
31            }
32        }
33
34        return ones + gain;
35    }
36}