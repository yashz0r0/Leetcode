// Last updated: 22/06/2026, 23:53:27
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int first=Integer.MAX_VALUE;
        int second= Integer.MAX_VALUE;

        for(int x:nums){
            if(x<=first){
                first=x;
            }else if(x<=second){
                second=x;
            }else{
                return true;
            }

        }


        return false;
        
    }
}