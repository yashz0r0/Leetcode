// Last updated: 22/06/2026, 23:59:46
class Solution {
    public int mirrorDistance(int n) {
        int reverse=0;
        int x=n;

        while(n!=0){
            int lastDig=n%10;
            reverse=reverse*10+lastDig;
            n/=10;
        }
        return Math.abs(x-reverse);
    }
}