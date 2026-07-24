// Last updated: 24/07/2026, 20:50:30
1class Solution {
2        public String tictactoe(int[][] moves) {
3        int[] A = new int[8], B = new int[8];  
4        for(int i=0;i<moves.length;i++) {
5            int r=moves[i][0], c=moves[i][1];
6            int[] player = (i%2==0)?A:B;
7            player[r]++;
8            player[c+3]++;
9            if(r==c) player[6]++;
10            if(r==2-c) player[7]++;
11        }
12        for(int i=0;i<8;i++) {
13            if(A[i]==3) return "A";
14            if(B[i]==3) return "B";
15        }
16        return moves.length==9 ? "Draw":"Pending";
17    }
18}