// Last updated: 23/06/2026, 00:02:58
class Solution {
    public int minimumDeletions(String s) {

        int b=0;
        int del=0;

        for(char c:s.toCharArray()){
            if(c=='b'){
                b++;
            }else{
                del= Math.min(del+1,b);
            }
        }
        return del;
    }
}