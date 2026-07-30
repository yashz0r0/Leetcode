// Last updated: 30/07/2026, 20:43:06
1class Solution {
2    public int minimumPushes(String word) {
3        int n = word.length();
4        int pushCnt = 0;
5
6        for(int i = 0; i < n; i++){
7            pushCnt += i / 8 + 1;
8        }
9
10        return pushCnt;
11    }
12}