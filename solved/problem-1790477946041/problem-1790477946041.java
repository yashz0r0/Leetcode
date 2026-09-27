// Last updated: 27/09/2026, 08:29:06
1class Solution {
2    public int maxSubarray(int[] nums) {
3       int n = nums.length;
4        int maxlen = 0;
5        
6        int[] pairsum = new int[1005];
7        int[] diff = new int[1005];
8        int[] window = new int[n];
9
10        for (int l = 0; l < n; l++) {
11            int marker = l + 1; 
12            int size = 0;
13
14            for (int r = l; r < n; r++) {
15                int x = nums[r];
16
17                if (pairsum[x] == marker || diff[x] == marker) {
18                    break;
19                }
20
21                for (int i = 0; i < size; i++) {
22                    int y = window[i];
23                    
24                    int sum = x + y;
25                    if (sum <= 1000) {
26                        pairsum[sum] = marker;
27                    }
28                    
29                    int d = x - y;
30                    if (d < 0) d = -d;
31                    diff[d] = marker;
32                }
33                
34                window[size++] = x;
35                if (size > maxlen) {
36                    maxlen = size;
37                }
38            }
39        }
40        return maxlen;
41    }
42}