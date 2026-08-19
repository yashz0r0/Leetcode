// Last updated: 19/08/2026, 21:15:06
1class Solution {
2    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
3
4        int l = 0, r = 0, prev = 0;
5        int sz = reservedSeats.length;
6
7        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);
8
9        boolean[] isReserved = new boolean[11];
10        int ans = 0;
11
12        while (r < sz) {
13
14            ans += 2 * (reservedSeats[r][0] - prev - 1);
15
16            prev = reservedSeats[r][0];
17
18            while (r < sz && reservedSeats[l][0] == reservedSeats[r][0]) {
19                isReserved[reservedSeats[r][1]] = true;
20                r++;
21            }
22
23            // Check the three possible groups
24            boolean twoToFive = check(isReserved, 2, 5);
25            boolean fourToSeven = check(isReserved, 4, 7);
26            boolean sixToNine = check(isReserved, 6, 9);
27
28            if (twoToFive && sixToNine) {
29                ans += 2;
30            }
31            else if (twoToFive || fourToSeven || sixToNine) {
32                ans++;
33            }
34
35            l = r;
36
37            Arrays.fill(isReserved, false);
38        }
39
40        ans += 2 * (n - prev);
41
42        return ans;
43    }
44
45    public boolean check(boolean[] b, int l, int r) {
46        for (int i = l; i <= r; i++) {
47            if (b[i]) {
48                return false;
49            }
50        }
51        return true;
52    }
53}