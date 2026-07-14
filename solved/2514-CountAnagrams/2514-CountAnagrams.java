// Last updated: 15/07/2026, 00:29:39
1
2class Solution {
3    public int countAnagrams(String s) {
4        long MOD = 1_000_000_007;
5        String[] words = s.split(" ");
6        int maxLen = 0;
7        for (String word : words) {
8            maxLen = Math.max(maxLen, word.length());
9        }
10        
11        long[] fact = new long[maxLen + 1];
12        fact[0] = 1;
13        for (int i = 1; i <= maxLen; i++) {
14            fact[i] = fact[i - 1] * i % MOD;
15        }
16        
17        long ans = 1;
18        for (String word : words) {
19            long count = fact[word.length()];
20            int[] freq = new int[26];
21            for (char c : word.toCharArray()) {
22                freq[c - 'a']++;
23            }
24            for (int f : freq) {
25                if (f > 1) count = count * modInverse(fact[f], MOD) % MOD;
26            }
27            ans = ans * count % MOD;
28        }
29        return (int) ans;
30    }
31    
32    private long modInverse(long x, long mod) {
33        long res = 1, pow = mod - 2;
34        while (pow > 0) {
35            if ((pow & 1) == 1) res = res * x % mod;
36            x = x * x % mod;
37            pow >>= 1;
38        }
39        return res;
40    }
41}