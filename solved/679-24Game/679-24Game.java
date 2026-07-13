// Last updated: 13/07/2026, 22:54:39
1class Solution {
2    final double EPS = 1e-6;
3
4    public boolean judgePoint24(int[] cards) {
5        List<Double> nums = new ArrayList<>();
6        for (int n : cards) nums.add((double) n);
7        return dfs(nums);
8    }
9
10    private boolean dfs(List<Double> nums) {
11        if (nums.size() == 1) {
12            return Math.abs(nums.get(0) - 24.0) < EPS;
13        }
14        for (int i = 0; i < nums.size(); i++) {
15            for (int j = i+1; j < nums.size(); j++) {
16                if (i == j) continue;
17                List<Double> next = new ArrayList<>();
18                for (int k = 0; k < nums.size(); k++) {
19                    if (k != i && k != j) next.add(nums.get(k));
20                }
21                for (double val : compute(nums.get(i), nums.get(j))) {
22                    next.add(val);
23                    if (dfs(next)) return true;
24                    next.remove(next.size() - 1);
25                }
26            }
27        }
28        return false;
29    }
30
31    private List<Double> compute(double a, double b) {
32        List<Double> res = new ArrayList<>();
33        res.add(a + b);
34        res.add(a - b);
35        res.add(b - a);
36        res.add(a * b);
37        if (Math.abs(b) > EPS) res.add(a / b);
38        if (Math.abs(a) > EPS) res.add(b / a);
39        return res;
40    }
41}