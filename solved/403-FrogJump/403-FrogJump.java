// Last updated: 13/07/2026, 22:52:46
1class Solution {
2    int[] stones;
3    Boolean[][] dp;
4
5    boolean rec(int idx, int jump) {
6        if (idx == stones.length - 1)
7            return true;
8
9        if (dp[idx][jump] != null)
10            return dp[idx][jump];
11
12        for (int next = idx + 1; next < stones.length; next++) {
13            int dist = stones[next] - stones[idx];
14
15            if (dist < jump - 1)
16                continue;
17
18            if (dist > jump + 1)
19                break;
20
21            if (rec(next, dist))
22                return dp[idx][jump] = true;
23        }
24
25        return dp[idx][jump] = false;
26    }
27
28    public boolean canCross(int[] stones) {
29        this.stones = stones;
30
31        if (stones[1] != 1)
32            return false;
33
34        int n = stones.length;
35        dp = new Boolean[n][n + 1];
36
37        return rec(1, 1);
38    }
39}