// Last updated: 24/07/2026, 11:34:54
1class Solution {
2    public int lowerbound(int[] nums, int target) {
3        int lo = 0;
4        int hi = nums.length - 1;
5
6        while (hi - lo > 1) {
7            int mid = lo + (hi - lo) / 2;
8            if (nums[mid] < target) {   // FIX: nums[mid]
9                lo = mid + 1;
10            } else {
11                hi = mid;
12            }
13        }
14
15        if (nums[lo] == target) return lo;
16        if (nums[hi] == target) return hi;
17        return -1;
18    }
19
20    public int upperbound(int[] nums, int target) {
21        int lo = 0;
22        int hi = nums.length - 1;
23
24        while (hi - lo > 1) {
25            int mid = lo + (hi - lo) / 2;
26            if (nums[mid] <= target) {   // FIX: nums[mid]
27                lo = mid + 1;
28            } else {
29                hi = mid;
30            }
31        }
32
33        if (nums[lo] > target) return lo;   
34        if (nums[hi] > target) return hi;  
35        return nums.length;   
36    }              
37
38    public int[] searchRange(int[] nums, int target) {
39
40        if (nums.length == 0) return new int[]{-1, -1};
41        if (nums.length == 1) {
42            if (nums[0] == target) return new int[]{0, 0};
43            return new int[]{-1, -1};
44        }
45
46        int lb = lowerbound(nums, target);
47        int ub = upperbound(nums, target);
48
49        if (lb == -1)
50            return new int[]{-1, -1};
51
52        ub--;
53
54        return new int[]{lb, ub};
55    }
56}