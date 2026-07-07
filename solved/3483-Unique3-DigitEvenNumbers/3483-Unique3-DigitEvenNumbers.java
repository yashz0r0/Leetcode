// Last updated: 07/07/2026, 22:56:46
1class Solution {
2    public int totalNumbers(int[] digits) {
3        int n= digits.length;
4        HashSet<Integer> set = new HashSet<>();
5
6        for (int i = 0; i < n; i++) {
7            if (digits[i] == 0) continue;      
8            for (int j = 0; j < n; j++) {
9                if (j == i) continue;
10
11                for (int k = 0; k < n; k++) {
12                    if (k == i || k == j) continue;
13
14                    if (digits[k] % 2 != 0) continue;
15
16                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
17                    set.add(num);
18                }
19            }
20        }
21
22        return set.size();
23                
24    }
25}