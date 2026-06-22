// Last updated: 23/06/2026, 00:00:41
class Solution {
    public int largestPrime(int n) {
            int sum=2;
        if(n<2) return 0;
        if(n==2) return sum;

        int lastPrime=2;
    

        for(int i=3;i<=n;i++){
            
            if(isPrime(i)) sum+=i;
            if(sum>n) break;

            if(isPrime(sum)){
                lastPrime=sum;
            }

            
        }


        return lastPrime;
        
    }

    boolean isPrime(int x){
        if(x<2) return false;
        if(x==2) return false;
        if(x%2==0) return false;

        for(int i=3;i*i<=x;i+=2){
            if(x%i==0) return false;
        }

        return true;
    }
}