// Last updated: 22/06/2026, 23:58:56
class Solution {
    public int countCommas(int n) {

          long total=0;
        long start=1000;

        while(start<=n){
            total+=(n-start+1);
            start*=1000;
        }
        

        return (int)total;
        
    }
}