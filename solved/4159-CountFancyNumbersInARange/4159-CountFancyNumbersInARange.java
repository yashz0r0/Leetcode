// Last updated: 22/06/2026, 23:59:56
import java.util.*;

class Solution {

    boolean isGood(int n) {
        if (n <= 0) return false;
        if (n < 10) return true;

        int prev = n % 10;
        n /= 10;

        boolean inc = true, dec = true;

        while (n > 0) {
            int curr = n % 10;

            if (curr >= prev) dec = false;
            if (curr <= prev) inc = false;

            if (!inc && !dec) return false;

            prev = curr;
            n /= 10;
        }

        return inc || dec;
    }

    long solve(long x) {
        if (x <= 0) return 0;

        String s = String.valueOf(x);
        int n = s.length();

        // dp[pos][last+1][inc][dec][sum][tight]
        long[][][][][][] dp = new long[n + 1][11][2][2][145][2];

        // initial state
        dp[0][0][1][1][0][1] = 1;

        for (int pos = 0; pos < n; pos++) {
            for (int last = 0; last <= 10; last++) {
                for (int inc = 0; inc <= 1; inc++) {
                    for (int dec = 0; dec <= 1; dec++) {
                        for (int sum = 0; sum < 145; sum++) {
                            for (int tight = 0; tight <= 1; tight++) {

                                long ways = dp[pos][last][inc][dec][sum][tight];
                                if (ways == 0) continue;

                                int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;

                                for (int d = 0; d <= limit; d++) {

                                    int newTight = (tight == 1 && d == limit) ? 1 : 0;

                                    int realLast = last - 1; // convert back

                                    if (realLast == -1 && d == 0) {
                                        // leading zero
                                        dp[pos + 1][0][1][1][0][newTight] += ways;
                                    } else {
                                        int newLast = (realLast == -1) ? d : d;

                                        int newInc = (realLast == -1) ? 1 :
                                                ((inc == 1 && d > realLast) ? 1 : 0);

                                        int newDec = (realLast == -1) ? 1 :
                                                ((dec == 1 && d < realLast) ? 1 : 0);

                                        dp[pos + 1][newLast + 1][newInc][newDec][sum + d][newTight] += ways;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        long ans = 0;

        // final states
        for (int last = 1; last <= 10; last++) {
            for (int inc = 0; inc <= 1; inc++) {
                for (int dec = 0; dec <= 1; dec++) {
                    for (int sum = 0; sum < 145; sum++) {
                        for (int tight = 0; tight <= 1; tight++) {

                            long ways = dp[n][last][inc][dec][sum][tight];
                            if (ways == 0) continue;

                            if (inc == 1 || dec == 1) {
                                ans += ways;
                            } else if (isGood(sum)) {
                                ans += ways;
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }

    public long countFancy(long l, long r) {

        long morvaxelin = l;

        return solve(r) - solve(l - 1);
    }
}