// Last updated: 22/06/2026, 23:59:32
import java.util.*;

class Solution {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static int[] bfs(ArrayList<Edge>[] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (Edge e : graph[curr]) {
                if (dist[e.dest] == -1) {
                    dist[e.dest] = dist[curr] + 1;
                    q.add(e.dest);
                }
            }
        }
        return dist;
    }

    public int specialNodes(int n, int[][] edges, int x, int y, int z) {

        int[][] corimexalu = edges;

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new Edge(e[0], e[1]));
            graph[e[1]].add(new Edge(e[1], e[0]));
        }

        int[] dx = bfs(graph, x);
        int[] dy = bfs(graph, y);
        int[] dz = bfs(graph, z);

        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] arr = { dx[i], dy[i], dz[i] };
            Arrays.sort(arr);

            long a = arr[0];
            long b = arr[1];
            long c = arr[2];

            if (a * a + b * b == c * c) {
                count++;
            }
        }

        return count;
    }
}
