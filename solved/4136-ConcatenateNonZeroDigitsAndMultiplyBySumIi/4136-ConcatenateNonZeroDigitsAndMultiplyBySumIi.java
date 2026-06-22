// Last updated: 23/06/2026, 00:00:19
class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int mod = 1_000_000_007;

        long[] prefSum = new long[n + 1];
        long[] prefNum = new long[n + 1];
        long[] pow10 = new long[n + 1];
        int[] prefCnt = new int[n + 1]; 

        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int d = c - '0';

            prefSum[i + 1] = prefSum[i] + (d == 0 ? 0 : d);
            prefCnt[i + 1] = prefCnt[i] + (d == 0 ? 0 : 1);

            if (d != 0) {
                prefNum[i + 1] = (prefNum[i] * 10 + d) % mod;
            } else {
                prefNum[i + 1] = prefNum[i];
            }
        }

        int q = queries.length;
        int[] res = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            long sum = prefSum[r + 1] - prefSum[l];
            long x = prefNum[r + 1];
            long left = prefNum[l];

            int digits = prefCnt[r + 1] - prefCnt[l];

            if (digits > 0) {
                x = (x - (left * pow10[digits]) % mod + mod) % mod;
            } else {
                x = 0;
            }

            res[i] = (int) ((x * (sum % mod)) % mod);
        }

        return res;
    }
    }
