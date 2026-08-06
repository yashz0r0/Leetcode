// Last updated: 06/08/2026, 11:21:17
1class Solution {
2    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
3    List<List<Integer>> adj = new ArrayList<>();
4        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
5        for (int[] inv : invocations) {
6            adj.get(inv[0]).add(inv[1]);
7        }
8
9        // Step 1: BFS from k to find all affected (suspicious) nodes
10        boolean[] affected = new boolean[n];
11        affected[k] = true;
12        Queue<Integer> queue = new LinkedList<>();
13        queue.add(k);
14
15        while (!queue.isEmpty()) {
16            int node = queue.poll();
17            for (int next : adj.get(node)) {
18                if (!affected[next]) {
19                    affected[next] = true;
20                    queue.add(next);
21                }
22            }
23        }
24
25        // Step 2: multi-source BFS from all NON-affected nodes
26        // to check if any affected node is reachable from outside
27        boolean[] visited = new boolean[n];
28        Queue<Integer> queue2 = new LinkedList<>();
29        for (int i = 0; i < n; i++) {
30            if (!affected[i]) {
31                visited[i] = true;
32                queue2.add(i);
33            }
34        }
35
36        boolean canRemove = true;
37        while (!queue2.isEmpty()) {
38            int node = queue2.poll();
39            for (int next : adj.get(node)) {
40                if (affected[next]) {
41                    // a non-affected node reaches an affected node
42                    canRemove = false;
43                }
44                if (!visited[next]) {
45                    visited[next] = true;
46                    queue2.add(next);
47                }
48            }
49        }
50
51        // Step 3: build result
52        List<Integer> result = new ArrayList<>();
53        if (!canRemove) {
54            // return everything
55            for (int i = 0; i < n; i++) result.add(i);
56        } else {
57            // return only non-affected nodes
58            for (int i = 0; i < n; i++) {
59                if (!affected[i]) result.add(i);
60            }
61        }
62        return result;
63    }
64}