// Last updated: 22/06/2026, 23:57:49
class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int sum=0;
        int l=Math.max(1,n-k);
        int r=n+k;

        for(int x=l;x<=r;x++){
            if((n&x)==0)sum+=x;
        }
        return sum;
    }
}