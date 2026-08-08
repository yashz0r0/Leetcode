// Last updated: 08/08/2026, 23:14:39
1class Solution {
2    public long countRatioSubarrays(int[] nums, int a, int b) {
3        int n = nums.length;
4
5        long[] evenPrefix = new long[n + 1];
6        long[] oddPrefix = new long[n + 1];
7
8        for (int i = 1; i <= n; i++) {
9            evenPrefix[i] = evenPrefix[i - 1];
10            oddPrefix[i] = oddPrefix[i - 1];
11
12            if ((nums[i - 1] & 1) == 0) {
13                evenPrefix[i]++;
14            } else {
15                oddPrefix[i]++;
16            }
17        }
18
19        long[] prefixValue = new long[n + 1];
20        for (int i = 0; i <= n; i++) {
21            prefixValue[i] = (long) b * evenPrefix[i] - (long) a * oddPrefix[i];
22        }
23
24        long[] sortedValues = prefixValue.clone();
25        Arrays.sort(sortedValues);
26
27        long[] uniqueValues = new long[n + 1];
28        int uniqueCount = 0;
29
30        for (long value : sortedValues) {
31            if (uniqueCount == 0 || uniqueValues[uniqueCount - 1] != value) {
32                uniqueValues[uniqueCount++] = value;
33            }
34        }
35
36        int[] fenwick = new int[uniqueCount + 1];
37
38        long res = 0;
39        int leftPointer = 0;
40
41        for (int right = 0; right <= n; right++) {
42            while (leftPointer < right && oddPrefix[leftPointer] < oddPrefix[right]) {
43                int rank = Arrays.binarySearch(uniqueValues, 0, uniqueCount, prefixValue[leftPointer]) + 1;
44
45                updateFenwick(fenwick, uniqueCount, rank, 1);
46                leftPointer++;
47            }
48
49            int currentRank = Arrays.binarySearch(uniqueValues, 0, uniqueCount, prefixValue[right]) + 1;
50
51            int smallerCount = queryFenwick(fenwick, currentRank - 1);
52
53            res += (long) leftPointer - smallerCount;
54        }
55
56        return res;
57    }
58
59    private void updateFenwick(int[] fenwick, int size, int index, int value) {
60        while (index <= size) {
61            fenwick[index] += value;
62            index += index & -index;
63        }
64    }
65
66    private int queryFenwick(int[] fenwick, int index) {
67        int sum = 0;
68
69        while (index > 0) {
70            sum += fenwick[index];
71            index -= index & -index;
72        }
73
74        return sum;
75    }
76}