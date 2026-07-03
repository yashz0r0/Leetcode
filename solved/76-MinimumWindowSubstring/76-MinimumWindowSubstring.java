// Last updated: 03/07/2026, 23:40:10
1class Solution {
2    public String minWindow(String s, String t) {
3        if (s.length() < t.length()) {
4            return "";
5        }
6
7        Map<Character, Integer> charCount = new HashMap<>();
8        for (char ch : t.toCharArray()) {
9            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
10        }
11
12        int targetCharsRemaining = t.length();
13        int[] minWindow = {0, Integer.MAX_VALUE};
14        int startIndex = 0;
15
16        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
17            char ch = s.charAt(endIndex);
18            if (charCount.containsKey(ch) && charCount.get(ch) > 0) {
19                targetCharsRemaining--;
20            }
21            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
22
23            if (targetCharsRemaining == 0) {
24                while (true) {
25                    char charAtStart = s.charAt(startIndex);
26                    if (charCount.containsKey(charAtStart) && charCount.get(charAtStart) == 0) {
27                        break;
28                    }
29                    charCount.put(charAtStart, charCount.getOrDefault(charAtStart, 0) + 1);
30                    startIndex++;
31                }
32
33                if (endIndex - startIndex < minWindow[1] - minWindow[0]) {
34                    minWindow[0] = startIndex;
35                    minWindow[1] = endIndex;
36                }
37
38                charCount.put(s.charAt(startIndex), charCount.getOrDefault(s.charAt(startIndex), 0) + 1);
39                targetCharsRemaining++;
40                startIndex++;
41            }
42        }
43
44        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);        
45    }
46}