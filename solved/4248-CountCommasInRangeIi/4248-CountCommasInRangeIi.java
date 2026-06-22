// Last updated: 22/06/2026, 23:58:51
class Solution {
    public long countCommas(long n) {

        long total=0;
        long start=1000;

        while(start<=n){
            total+=(n-start+1);
            start*=1000;
        }
        

        return total;
        
    }
}