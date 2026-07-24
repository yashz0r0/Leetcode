// Last updated: 24/07/2026, 14:29:00
1class Solution {
2    public int mySqrt(int x) {
3        if (x == 0) return 0;
4
5        int lo = 1, hi = x;
6
7        while (hi-lo>1) {
8            int mid = lo + (hi - lo) / 2;
9
10            if (1L * mid * mid <= x) {
11                lo = mid ;
12            } else {
13                hi = mid;
14            }
15        }
16
17        return lo;
18    }
19}