// Last updated: 22/06/2026, 23:59:30
class Solution {
    class Edge{
        int src;
        int dest;
        int idx;

        Edge(int s, int d, int i){
            src=s;
            dest= d;
            idx=i;
        }
    }
    ArrayList<Edge>[] graph;
     ArrayList<Integer> ans;
     int[] diff;

    public int dfs(int curr, int parent){
        int need= diff[curr];
        for(Edge e:graph[curr]){
            if(e.dest== parent)continue;
            int childNeed= dfs(e.dest, curr);
            if(childNeed==1){
                ans.add(e.idx);
                need^=1;
            }
        }
        return need;
    }
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        graph= new ArrayList[n];
        ans= new ArrayList<>();

        for(int i=0;i<n;i++){
            graph[i]= new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v= edges[i][1];
            graph[u].add(new Edge(u,v,i));
            graph[v].add(new Edge(v,u,i));
        }

        diff= new int[n];
        for(int i=0;i<n;i++){
            diff[i]= (start.charAt(i)==target.charAt(i))?0:1;
        }

        int root = dfs(0,-1);

        if(root==1){
            return Arrays.asList(-1);
        }

        Collections.sort(ans);
        return ans;
    }
}