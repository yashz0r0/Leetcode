// Last updated: 06/08/2026, 11:37:54
1class Solution {
2    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
3        List<List<Integer>> g = new ArrayList<>();
4        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
5        for (int[] inv : invocations) g.get(inv[0]).add(inv[1]);
6
7        boolean[] affected = new boolean[n];
8        affected[k] = true;
9        Queue<Integer> q = new LinkedList<>();
10        q.add(k);
11        while (!q.isEmpty()) {
12            int node = q.poll();
13            for (int next : g.get(node)) {
14                if (!affected[next]) {
15                    affected[next] = true;
16                    q.add(next);
17                }
18            }
19        }
20
21        boolean[] visited = new boolean[n];
22        Queue<Integer> q2 = new LinkedList<>();
23        for (int i = 0; i < n; i++) {
24            if (!affected[i]) {
25                visited[i] = true;
26                q2.add(i);
27            }
28        }
29
30        boolean canrem = true;
31        while (!q2.isEmpty()) {
32            int node = q2.poll();
33            for (int next : g.get(node)) {
34                if (affected[next]) canrem = false;
35                if (!visited[next]) {
36                    visited[next] = true;
37                    q2.add(next);
38                }
39            }
40        }
41
42        List<Integer> result = new ArrayList<>();
43        for (int i = 0; i < n; i++) {
44            if (canrem) {
45                if (!affected[i]) result.add(i);
46            } else {
47                result.add(i);
48            }
49        }
50        return result;
51    }
52}
53
54
55
56