// Last updated: 10/08/2026, 12:57:29
1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3
4        int n = nums.length;
5
6        if (k > n) {
7            int max = nums[0];
8
9            for (int i = 0; i < n; i++) {
10                max = Math.max(max, nums[i]);
11            }
12
13            return new int[]{max};
14        }
15
16        int i = 0, j = 0, idx = 0;
17
18        Deque<Integer> dq = new LinkedList<>();
19
20        int[] res = new int[n - k + 1];
21
22        while (j < n) {
23
24            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[j]) {
25                dq.pollLast();
26            }
27
28            dq.offerLast(j);
29
30            if (j - i + 1 == k) {
31                while (!dq.isEmpty() && dq.peekFirst() < i) {
32                    dq.pollFirst();
33                }
34                res[idx++] = nums[dq.peekFirst()];
35
36                i++;
37            }
38
39            j++;
40        }
41
42        return res;
43    }
44}