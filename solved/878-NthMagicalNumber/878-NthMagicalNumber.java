// Last updated: 02/08/2026, 15:54:00
1class Solution {
2    static final int MOD = 1_000_000_007;
3
4    public int nthMagicalNumber(int n, int a, int b) {
5        long l = Math.min(a, b);
6        long r = (long) n * Math.min(a, b);
7
8        long lcm = (long) a * b / gcd(a, b);
9
10        while (l <= r) {
11            long mid = l + (r - l) / 2;
12
13            long count = mid / a + mid / b - mid / lcm;
14
15            if (count >= n) {
16                r = mid - 1;
17            } else {
18                l = mid + 1;
19            }
20        }
21
22        return (int) (l % MOD);
23    }
24
25    private long gcd(long a, long b) {
26        while (b != 0) {
27            long temp = a % b;
28            a = b;
29            b = temp;
30        }
31        return a;
32    }
33}