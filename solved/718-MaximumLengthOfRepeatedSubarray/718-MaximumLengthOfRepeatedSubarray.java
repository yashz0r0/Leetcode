// Last updated: 22/06/2026, 23:55:55
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n= nums2.length;
        int t[][]= new int[m+1][n+1];
        int max=0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1]==nums2[j-1]){
                     t[i][j]=1+t[i-1][j-1];
                     max= Math.max(t[i][j],max);
                }else{
                    t[i][j]=0;
                }
            }
        }

        return max;
        
    }
}