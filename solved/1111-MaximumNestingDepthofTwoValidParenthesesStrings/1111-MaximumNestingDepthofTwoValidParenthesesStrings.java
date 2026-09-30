// Last updated: 30/09/2026, 22:58:01
1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        int[] answer = new int[seq.length()];
4        int currentGroup = 1;
5
6        for (int index = 0; index < seq.length(); index++) {
7            char bracket = seq.charAt(index);
8
9            if (bracket == '(') {
10                answer[index] = 1 - currentGroup;
11            } else {
12                answer[index] = currentGroup;
13            }
14
15            currentGroup ^= 1;
16        }
17
18        return answer;
19    }
20}