// Last updated: 22/06/2026, 23:58:13
class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid= new int[n][m];
        Queue<int[]> q= new LinkedList<>();

        for(int[] s:sources){
            int r=s[0],c=s[1], color=s[2];
            grid[r][c]=color;
            q.offer(new int[]{r,c});
        }

        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int size=q.size();

            Map<Integer,Integer> map= new HashMap<>();

            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int r= curr[0], c=curr[1];
                int color= grid[r][c];
                for(int[] d:dirs){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==0){
                        int key= nr*m+nc;
                        map.put(key,Math.max(map.getOrDefault(key,0),color));
                    }
                }
            }
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                int key= entry.getKey();
                int r= key/m;
                int c=key%m;
                int color= entry.getValue();
                grid[r][c]=color;
                q.offer(new int[]{r,c});
            }
            
        } 

        return grid;
    }
}