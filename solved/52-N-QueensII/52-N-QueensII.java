// Last updated: 11/07/2026, 00:58:34
1class Solution {
2    private static int nQueens(int row, char[][] chessBoard) {
3        int n= chessBoard.length;
4        //valid solution found
5        if(row==n){
6            return 1;
7        }
8        int count=0;
9        for(int col=0;col<n;col++){
10            if(canQueensbePlaced(row,col,chessBoard)){
11                chessBoard[row][col]='Q';//marked valid place
12                count+=nQueens(row+1,chessBoard);//move the next state
13                chessBoard[row][col]='i';//unmarked
14            }
15        }
16        return count;
17    }
18
19    private static boolean canQueensbePlaced(int row, int col, char[][] chessBoard) {
20        int n = chessBoard.length;
21        int i = row - 1;
22        //check the col
23        while (i >= 0) {
24            if (chessBoard[i][col] == 'Q') return false;
25            i--;
26        }
27        //check the left diagonal
28        i = row - 1;
29        int j = col - 1;
30        while (i >= 0 && j >= 0) {
31            if (chessBoard[i][j] == 'Q') return false;
32            i--;
33            j--;
34        }
35        //check the right diagonal
36        i = row - 1;
37        j = col + 1;
38        while (i >= 0 && j < n) {
39            if (chessBoard[i][j] == 'Q') return false;
40            i--;
41            j++;
42        }
43        return true;
44    }
45    public int totalNQueens(int n) {
46        
47        char[][] chessBoard=new char[n][n];
48        for(int i=0;i<n;i++){
49            for(int j=0;j<n;j++){
50                chessBoard[i][j]='i';
51            }
52        }
53        int ans=nQueens(0,chessBoard);
54        return ans;
55    }
56}