// Last updated: 22/06/2026, 23:58:50
class Solution {
    static final int MOD = 1_000_000_007;
    public int countVisiblePeople(int n, int pos, int k) {
        
      if (k > n - 1) return 0;

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

      
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        // inverse factorial using Fermat's theorem
        invFact[n] = power(fact[n], MOD - 2);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        long ways = nCr(n - 1, k, fact, invFact);

        // multiply by 2 for pos
        ways = (ways * 2) % MOD;

        return (int) ways;
    }

    long nCr(int n, int r, long[] fact, long[] invFact) {
        if (r < 0 || r > n) return 0;
        return (fact[n] * invFact[r] % MOD * invFact[n - r] % MOD) % MOD;
    }

    long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}