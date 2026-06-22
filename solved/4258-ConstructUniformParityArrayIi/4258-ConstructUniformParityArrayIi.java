// Last updated: 22/06/2026, 23:58:40
class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE;
        boolean alleven=true;
        for(int x:nums1){
            min=Math.min(min,x);
            if(x%2!=0){
                alleven=false;
            }
        }
        if(alleven)return true;
        return min%2==1;
    }
}