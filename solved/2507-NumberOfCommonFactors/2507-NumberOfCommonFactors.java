// Last updated: 23/06/2026, 00:01:56
class Solution {
    public int commonFactors(int a, int b) {
        int cnt=0;
        int max=Math.max(a,b);

        for(int i=1;i<=max;i++){
            if(a%i==0&&b%i==0){
                cnt++;
            }
        }

        return cnt;
        
    }
}