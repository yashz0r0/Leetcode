// Last updated: 03/07/2026, 23:42:33
1import java.util.Arrays;
2
3class Solution {
4    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
5        int n = nums1.length;
6        int m = nums2.length;
7        int[] merged = new int[n + m];
8        int k = 0;
9        for (int i = 0; i < n; i++) {
10            merged[k++] = nums1[i];
11        }
12        for (int i = 0; i < m; i++) {
13            merged[k++] = nums2[i];
14        }
15        Arrays.sort(merged);
16        int total = merged.length;
17
18        if (total % 2 == 1) {
19            return (double) merged[total / 2];
20        } else {
21            int middle1 = merged[total / 2 - 1];
22            int middle2 = merged[total / 2];
23            return ((double) middle1 + (double) middle2) / 2.0;
24        }
25    }
26}