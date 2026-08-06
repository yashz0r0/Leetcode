// Last updated: 06/08/2026, 11:33:56
1class Solution {
2    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
3        List<List<Integer>> adj = new ArrayList<>();
4        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
5        for (int[] inv : invocations) adj.get(inv[0]).add(inv[1]);
6
7        boolean[] affected = new boolean[n];
8        affected[k] = true;
9        Queue<Integer> queue = new LinkedList<>();
10        queue.add(k);
11        while (!queue.isEmpty()) {
12            int node = queue.poll();
13            for (int next : adj.get(node)) {
14                if (!affected[next]) {
15                    affected[next] = true;
16                    queue.add(next);
17                }
18            }
19        }
20
21        boolean[] visited = new boolean[n];
22        Queue<Integer> queue2 = new LinkedList<>();
23        for (int i = 0; i < n; i++) {
24            if (!affected[i]) {
25                visited[i] = true;
26                queue2.add(i);
27            }
28        }
29
30        boolean canRemove = true;
31        while (!queue2.isEmpty()) {
32            int node = queue2.poll();
33            for (int next : adj.get(node)) {
34                if (affected[next]) canRemove = false;
35                if (!visited[next]) {
36                    visited[next] = true;
37                    queue2.add(next);
38                }
39            }
40        }
41
42        List<Integer> result = new ArrayList<>();
43        for (int i = 0; i < n; i++) {
44            if (canRemove) {
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