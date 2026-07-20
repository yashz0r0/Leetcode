// Last updated: 20/07/2026, 13:13:33
1class Solution {
2    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
3        List<List<Integer>> ans = new ArrayList<>();
4        int n = grid.length;
5        int m = grid[0].length;
6        int total = n *m;
7
8        for(int i =0 ;i < n;i++){
9            ans.add(new ArrayList<>(m));
10            for(int j = 0 ;j < m;j++){
11                ans.get(i).add(0);
12            }
13            
14        }
15
16
17        for(int i = 0 ;i < n;i++){      
18            for(int j =0 ;j < m;j++){
19                
20                int val = i * m +j;
21
22                int after = (val + k )% total;
23
24                int nrow = after/m;
25                int ncol = after % m;
26
27                ans.get(nrow).set(ncol , grid[i][j]);
28
29            }
30        }
31
32        return ans;
33    }
34}