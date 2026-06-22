// Last updated: 22/06/2026, 23:57:54
class Solution {
    public boolean consecutiveSetBits(int n) {
        int cnt=0;
        while(n>0){
            if((n&3)==3)cnt++;
            n>>=1;
        }
        return cnt==1;
        
    }
}