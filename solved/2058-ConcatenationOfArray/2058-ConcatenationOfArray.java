// Last updated: 23/06/2026, 00:02:31
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int res[] =new int[n+n];
       for(int i=0;i<n;i++){
        res[i]=nums[i];
       }

       for(int i=n;i<2*n;i++){
        res[i]=nums[i-n];
       }

return res;
        
    }
}