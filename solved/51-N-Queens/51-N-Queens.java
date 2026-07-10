// Last updated: 11/07/2026, 00:57:32
1class Solution {
2    public List<List<String>> solveNQueens(int n) {
3        List<List<String>> result = new ArrayList<>();
4        char[][] board = new char[n][n];
5
6        for (int i = 0; i < n; i++) {
7            Arrays.fill(board[i], '.');
8        }
9
10        nQueens(result, board, n, 0);
11        return result;
12    }
13
14    private void nQueens(List<List<String>> result, char[][] board, int n, int row) {
15
16        if (row == n) {
17            List<String> current = new ArrayList<>();
18
19            for (int i = 0; i < n; i++) {
20                current.add(new String(board[i]));
21            }
22
23            result.add(current);
24            return;
25        }
26
27        for (int col = 0; col < n; col++) {
28
29            if (isSafe(board, n, row, col)) {
30                board[row][col] = 'Q';
31                nQueens(result, board, n, row + 1);
32                board[row][col] = '.';
33            }
34        }
35    }
36
37    private boolean isSafe(char[][] board, int n, int row, int col) {
38
39        // Check column
40        for (int i = 0; i < n; i++) {
41            if (board[i][col] == 'Q') {
42                return false;
43            }
44        }
45
46        // Check row
47        for (int j = 0; j < n; j++) {
48            if (board[row][j] == 'Q') {
49                return false;
50            }
51        }
52
53        // Check left diagonal
54        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
55            if (board[i][j] == 'Q') {
56                return false;
57            }
58        }
59
60        // Check right diagonal
61        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
62            if (board[i][j] == 'Q') {
63                return false;
64            }
65        }
66
67        return true;
68    }
69}