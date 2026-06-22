// Last updated: 22/06/2026, 23:58:27
class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n=matrix.length;
        int res[]=new int[n];

        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    cnt++;
                }
            }
            res[i]=cnt;
        }
        return res;
    }
}