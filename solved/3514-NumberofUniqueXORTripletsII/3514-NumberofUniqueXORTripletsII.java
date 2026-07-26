// Last updated: 27/07/2026, 00:13:11
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        final int MAX_XOR = 2048;
4
5        boolean[] pairXor = new boolean[MAX_XOR];
6        boolean[] tripletXor = new boolean[MAX_XOR];
7
8        int n = nums.length;
9
10        for (int i = 0; i < n; i++) {
11            for (int j = i; j < n; j++) {
12                pairXor[nums[i] ^ nums[j]] = true;
13            }
14        }
15
16        for (int x = 0; x < MAX_XOR; x++) {
17            if (!pairXor[x]) continue;
18
19            for (int v : nums) {
20                tripletXor[x ^ v] = true;
21            }
22        }
23
24        int count = 0;
25        for (boolean exists : tripletXor) {
26            if (exists) count++;
27        }
28
29        return count;
30    }
31}