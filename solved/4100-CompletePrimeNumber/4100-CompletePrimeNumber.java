// Last updated: 23/06/2026, 00:00:33
class Solution {
    public boolean completePrime(int num) {
        String s= String.valueOf(num);

        int n= s.length();

        for(int i=1;i<=n;i++){
            int pref= Integer.parseInt(s.substring(0,i));
            if(!isPrime(pref)) return false;
        }

        for(int i=0;i<n;i++){
            int suff= Integer.parseInt(s.substring(i));
            if(!isPrime(suff)) return false;
        }


        return true;
        
    }

    public boolean isPrime(int x){
        if(x<2) return false;
        if(x==2||x==3) return true;
        if(x%2==0) return false;


        for(int i=3;i*i<=x;i+=2){
            if(x%i==0) return false;
        }

        return true;
    }
}