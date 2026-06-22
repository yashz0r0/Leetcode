// Last updated: 22/06/2026, 23:59:25
class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int cx= center[0];
        int cy=center[1];
        int max=-1;
        int bestx=-1;
        int besty=-1;

        for(int[] tower:towers){
            int x= tower[0];
            int y=tower[1];
            int q= tower[2];
            int dist= Math.abs(x-cx)+Math.abs(y-cy);

            if(dist<=radius){
                if(q>max||(q==max&&(bestx==-1||x<bestx||(x==bestx&&y<besty)))){
                    max=q;
                    bestx=x;
                    besty=y;
                    
                }
            }
        }
        if(max==-1){
            return new int[]{-1,-1};
        }

        return new int[]{bestx, besty};
    }
}