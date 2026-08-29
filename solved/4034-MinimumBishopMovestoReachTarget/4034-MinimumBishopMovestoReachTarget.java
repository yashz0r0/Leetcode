// Last updated: 29/08/2026, 21:33:58
1class Solution {
2    public int minBishopMoves(int[] source, int[] target) {
3         int b1=(source[0]+source[1])%2;
4        int b2=(target[0]+target[1])%2;
5
6        if(b1!=b2)
7        {
8            return -1;
9        }
10        if(Math.abs(source[0]-target[0])==Math.abs(source[1]-target[1]))
11        {
12            return 1;
13        }
14        return 2;
15    }
16}