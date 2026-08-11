// Last updated: 11/08/2026, 18:56:28
1class Solution {
2    public int missingInteger(int[] A) {
3        int n = A.length;
4        Set<Integer> seen = new HashSet<>(n);
5
6        for (int num : A)
7            seen.add(num);
8        int sum = A[0];
9
10        for (int i = 1; i < n; i++) {
11            if (A[i] == A[i - 1] + 1)
12                sum += A[i];
13            else break;
14        }
15
16        while (seen.contains(sum))
17            sum++;
18
19        return sum;
20    }
21}