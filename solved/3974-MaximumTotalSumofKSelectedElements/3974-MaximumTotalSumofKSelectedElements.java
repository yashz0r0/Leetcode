// Last updated: 30/06/2026, 11:05:13
1class Solution {
2    public long maxSum(int[] nums, int k, int mul) {
3        Arrays.sort(nums);
4        reverse(nums);
5
6        long ans = 0;
7
8        for (int i = 0; i < k; i++) {
9            if (mul > 1)
10                ans += 1L * nums[i] * mul;
11            else
12                ans += nums[i];
13            mul--;
14        }
15
16        return ans;
17    }
18
19    private void reverse(int[] arr) {
20        int start = 0, end = arr.length - 1;
21        while (start < end) {
22            int temp = arr[start];
23            arr[start] = arr[end];
24            arr[end] = temp;
25            start++;
26            end--;
27        }
28    }
29}