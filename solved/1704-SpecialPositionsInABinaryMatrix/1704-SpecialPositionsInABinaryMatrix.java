// Last updated: 23/06/2026, 00:02:59
class Solution {
    public int numSpecial(int[][] mat) {
        int cnt=0;
        for(int i=0;i< mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1&&check(i,j, mat)){
                    cnt++;
                }
            }
        }

        return cnt;
        
    }
    public boolean check(int row, int col, int[][] mat){
        for(int i=0;i<mat[0].length;i++) if(mat[row][i]!=0&&i!=col)return false;
        for(int j=0;j< mat.length;j++)if(mat[j][col]!=0&&j!=row)return false;

        return true;
    }


}