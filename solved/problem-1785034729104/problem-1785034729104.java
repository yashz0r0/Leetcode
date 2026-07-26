// Last updated: 26/07/2026, 08:28:49
1class Solution {
2    long MOD=1000000007;
3    public int countValidSequences(int n, int k) {
4        if(n<k)return 0;
5        long tot=nCr(n-1,k-1);
6        long odd=0;
7        if((n-k)%2==0){
8            int m=(n-k)/2;
9            odd=nCr(m+k-1,k-1);
10        }
11        return (int)((tot-odd+MOD)%MOD);
12        
13    }
14    private long nCr(int n, int r) {
15        if (r < 0 || r > n) return 0;
16        if (r == 0 || r == n) return 1;
17        if (r > n - r) r = n - r;
18        
19        long num = 1;
20        long den = 1;
21        
22        for (int i = 0; i < r; i++) {
23            num = (num * (n - i)) % MOD;
24            den = (den * (i + 1)) % MOD;
25        }
26        
27        return (num * power(den, MOD - 2)) % MOD;
28    }
29    
30    private long power(long base, long exp) {
31        long res = 1;
32        base %= MOD;
33        while (exp > 0) {
34            if (exp % 2 == 1) res = (res * base) % MOD;
35            base = (base * base) % MOD;
36            exp /= 2;
37        }
38        return res;
39}
40
41}