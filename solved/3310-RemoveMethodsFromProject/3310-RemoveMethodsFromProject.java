// Last updated: 05/08/2026, 21:55:12
1class Solution {
2    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
3        List<Integer>[] edges = new ArrayList[n];
4        for (int i = 0; i < n; i++) {
5            edges[i] = new ArrayList<>();
6        }
7        int[] inDegree = new int[n];
8
9        for (int[] inv : invocations) {
10            edges[inv[0]].add(inv[1]);
11            inDegree[inv[1]]++;
12        }
13
14        Queue<Integer> queue = new ArrayDeque<>();
15        queue.offer(k);
16        boolean[] sus = new boolean[n];
17        sus[k] = true;
18
19
20        while (!queue.isEmpty()) {
21            int u = queue.poll();
22            for (int v : edges[u]) {
23                inDegree[v]--;
24
25                if (!sus[v]) {
26                    queue.offer(v);
27                    sus[v] = true;
28                }
29            }
30        }
31
32        boolean canRemoveAll = true;
33        List<Integer> rem = new ArrayList<>();
34
35        for (int i = 0; i < n; i++) {
36            if (sus[i] && inDegree[i] > 0) {
37                canRemoveAll = false;
38                break;
39            } else if (!sus[i]) {
40                rem.add(i);
41            }
42        }
43
44        if (!canRemoveAll) {
45            List<Integer> allNodes = new ArrayList<>(n);
46            for (int i = 0; i < n; i++) {
47                allNodes.add(i);
48            }
49            return allNodes;
50        }
51
52        return rem;
53    }
54}