// Last updated: 29/07/2026, 00:38:58
1class Solution {
2      public int maxPoints(int[][] arr) {
3        int max = 1;
4        for (int i = 0; i < arr.length; i++) {
5            HashMap<Double, Integer> map = new HashMap<>();
6            for (int j = 0; j < arr.length; j++) {
7                if (i == j) continue;
8                double slope = (arr[j][0] - arr[i][0]) != 0 ? (arr[j][1] - arr[i][1]) * 1.0 / (arr[j][0] - arr[i][0]) : Integer.MAX_VALUE;
9                map.put(slope, map.getOrDefault(slope, 1) + 1);
10                max = Math.max(max, map.get(slope));
11            }
12        }
13        return max;
14    }
15}