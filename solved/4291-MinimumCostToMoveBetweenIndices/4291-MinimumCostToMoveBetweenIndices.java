// Last updated: 22/06/2026, 23:58:00
class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] closet= new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                closet[i]=1;
            }else if(i==n-1){
                closet[i]=n-2;
            }else{
                int left=nums[i]-nums[i-1];
                int right=nums[i+1]-nums[i];

                if(left<=right){
                    closet[i]=i-1;
                }else{
                    closet[i]=i+1;
                }
            }
        }

        long[] forward= new long[n];
        for(int i=1;i<n;i++){
            if(closet[i-1]==i){
                forward[i]=forward[i-1]+1;
            }else{
                forward[i]=forward[i-1]+(nums[i]-nums[i-1]);
            }
        }
        long[] backward= new long[n];
        for(int i=n-2;i>=0;i--){
            if(closet[i+1]==i){
                backward[i]=backward[i+1]+1;
            }else{
                backward[i]=backward[i+1]+(nums[i+1]-nums[i]);
            }
        }
        int[] ans= new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            if(l<r){
                ans[i]=(int)(forward[r]-forward[l]);
            }else{
                ans[i]=(int)(backward[r]-backward[l]);
            }
        }

        return ans;
    }
}