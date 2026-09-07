// Last updated: 07/09/2026, 21:18:54
1class Solution {
2    public int countGoodRotations(int[] nums) {
3        int k = nums.length / 2;
4        int cnt = 0;
5
6        int i = 0;
7        int j = 0;
8        int n = nums.length;
9
10        long total = 0;
11        for (int x : nums) {
12            total += x;
13        }
14
15        long sum = 0;
16
17        while (i < n) {
18            sum += nums[j % n];
19
20            if (j - i + 1 < k) {
21                j++;
22            } 
23            else if (j - i + 1 == k) {
24
25                if (sum > total - sum) {
26                    cnt++;
27                }
28
29                sum -= nums[i % n];
30                i++;
31                j++;
32            }
33        }
34
35        return cnt;
36    }
37}