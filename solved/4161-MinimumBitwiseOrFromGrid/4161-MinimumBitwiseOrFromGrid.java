// Last updated: 22/06/2026, 23:59:52
class Solution {
    public int minimumOR(int[][] grid) {

        int left=0;
        int right= (1<<17)-1;
        int ans= right;

        while(left<=right){
            int mid= left+(right-left)/2;

            if(isPossible(grid,mid)){
                ans= mid;
                right= mid-1;
            }else{
                left=mid+1;
            }
            
        }

        return ans;
       
        
    }

    public boolean isPossible(int[][] grid, int x){
        for(int[] row:grid){
            boolean found = false;
            for(int val:row){
                if((val|x)==x){
                    found =true;
                    break;
                }

                
            }
            if(!found)return false;
        }

        return true;
    }
}