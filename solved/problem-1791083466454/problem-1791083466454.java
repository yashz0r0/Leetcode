// Last updated: 04/10/2026, 08:41:06
1class Solution {
2    public final int mod=1000000007;
3    public int countGoodStrings(long n) {
4        long[] fib=fib(n);
5        return (int)((2*fib[0])%mod);
6    }
7
8    public long[] fib(long k){
9        if(k==0){
10            return new long[]{0,1};
11        }
12
13        long[] p=fib(k/2);
14        long fk=p[0];
15        long fk1=p[1];
16
17        long f2k=fk*((2*fk1-fk+mod)%mod)%mod;
18        long f2k1=(fk*fk%mod+fk1*fk1%mod)%mod;
19        if(k%2==0){
20            return new long[]{f2k,f2k1};
21        }else{
22            return new long[]{f2k1,(f2k+f2k1)%mod};
23        }
24    }
25}