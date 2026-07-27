// Last updated: 27/07/2026, 13:22:37
1class Solution {
2    public int minBitFlips(int start, int goal) {
3        start=start^goal;
4        int cnt=0;
5        while(start!=0){
6            start=start&(start-1);
7            cnt++;
8        }
9        return cnt;
10    }
11}