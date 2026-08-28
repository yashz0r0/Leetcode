// Last updated: 28/08/2026, 22:49:47
1public class Solution {
2public void setZeroes(int[][] matrix) {
3    boolean fr = false,fc = false;
4    for(int i = 0; i < matrix.length; i++) {
5        for(int j = 0; j < matrix[0].length; j++) {
6            if(matrix[i][j] == 0) {
7                if(i == 0) fr = true;
8                if(j == 0) fc = true;
9                matrix[0][j] = 0;
10                matrix[i][0] = 0;
11            }
12        }
13    }
14    for(int i = 1; i < matrix.length; i++) {
15        for(int j = 1; j < matrix[0].length; j++) {
16            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
17                matrix[i][j] = 0;
18        }}
19    }
20    if(fr) {
21        for(int j = 0; j < matrix[0].length; j++) {
22            matrix[0][j] = 0;
23        }
24    }
25    if(fc) {
26        for(int i = 0; i < matrix.length; i++) {
27            matrix[i][0] = 0;
28        }
29    }
30}}  