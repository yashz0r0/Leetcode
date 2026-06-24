// Last updated: 24/06/2026, 22:53:40
1class Solution {
2    final long MOD = 1_000_000_007L;
3    public int countGoodNumbers(long n) {
4        long even=(n+1)/2;
5        long odd=n/2;
6        long ans=(pow(5,even)*pow(4,odd))%MOD;
7        return (int)ans;
8    }
9
10   private long pow(long base, long exp) {
11        long res = 1;
12
13        while (exp > 0) {
14            if ((exp & 1) == 1) {
15                res = (res * base) % MOD;
16            }
17
18            base = (base * base) % MOD;
19            exp >>= 1;
20        }
21
22        return res;
23    }
24}