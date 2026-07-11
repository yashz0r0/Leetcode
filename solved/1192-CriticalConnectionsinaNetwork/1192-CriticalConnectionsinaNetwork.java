// Last updated: 11/07/2026, 20:56:04
1class Solution {
2    int[] disc, low;
3    int time = 1;
4    List<List<Integer>> ans = new ArrayList<>();
5    Map<Integer,List<Integer>> edgeMap = new HashMap<>();
6    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
7        disc = new int[n];
8        low = new int[n];
9        for (int i = 0; i < n; i++)
10            edgeMap.put(i, new ArrayList<Integer>());
11        for (List<Integer> conn : connections) {
12            edgeMap.get(conn.get(0)).add(conn.get(1));
13            edgeMap.get(conn.get(1)).add(conn.get(0));
14        }
15        dfs(0, -1);
16        return ans;
17    }
18    public void dfs(int curr, int prev) {
19        disc[curr] = low[curr] = time++;
20        for (int next : edgeMap.get(curr)) {
21            if (disc[next] == 0) {
22                dfs(next, curr);
23                low[curr] = Math.min(low[curr], low[next]);
24            } else if (next != prev)
25                low[curr] = Math.min(low[curr], disc[next]);
26            if (low[next] > disc[curr]) 
27                ans.add(Arrays.asList(curr, next));
28        }
29    }
30}