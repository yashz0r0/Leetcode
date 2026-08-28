// Last updated: 28/08/2026, 23:00:19
1class Solution {
2    public void setZeroes(int[][] mat) {
3        int m=mat.length;
4        int n=mat[0].length;
5
6        List<Integer> row= new ArrayList<>();
7        List<Integer> col= new ArrayList<>();
8
9        for(int i=0;i<m;i++){
10            for(int j=0;j<n;j++){
11                if(mat[i][j]==0){
12                    row.add(i);
13                    col.add(j);
14                }
15            }
16        }
17
18        for(int r:row){
19            for(int i=0;i<n;i++ ){
20                mat[r][i]=0;
21            }
22        }
23
24        for(int c:col){
25            for(int i=0;i<m;i++ ){
26                mat[i][c]=0;
27            }
28        }
29    }
30}