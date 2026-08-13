// Last updated: 13/08/2026, 23:16:09
1class Solution {
2    public List<List<Integer>> permute(int[] nums) {
3
4        List<List<Integer>> list = new ArrayList<>();
5        List<Integer> ip = new ArrayList<>();
6
7        for (int x : nums) {
8            ip.add(x);
9        }
10
11        solve(ip, new ArrayList<>(), list);
12
13        return list;
14    }
15
16    public void solve(List<Integer> ip, List<Integer> op, List<List<Integer>> list) {
17
18        if (ip.size() == 0) {
19            list.add(new ArrayList<>(op));
20            return;
21        }
22
23        for (int i = 0; i < ip.size(); i++) {
24
25            int dig = ip.get(i);
26
27            ip.remove(i);
28            op.add(dig);
29
30            solve(ip, op, list);
31
32            op.remove(op.size() - 1);
33            ip.add(i, dig);
34        }
35    }
36}