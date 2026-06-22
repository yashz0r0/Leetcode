// Last updated: 22/06/2026, 23:58:07
class Solution {
    public int sumOfPrimesInRange(int n) {
        int r= Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());

        int sum=0;
        int st= Math.min(n,r);
        int end=Math.max(n,r);
        for(int  i=st;i<=end;i++){
            if(isPrime(i)){
                sum+=i;
            }
        }

        return sum;
    }

    private boolean isPrime(int n){
        if(n<=1)return false;
        if(n==2)return true;
        if(n%2==0)return false;
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0)return false;
        }
        return true;
    }
}