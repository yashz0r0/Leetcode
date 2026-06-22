// Last updated: 23/06/2026, 00:01:22
class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {

        Arrays.sort(points, (a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });

        int cnt=0;

        int lim=points[0][0]+w;


        for(int[] a: points){
            int x=a[0];
            int y=a[1];

            if(x>lim){
                lim=x+w;
                cnt++;
            }

        

            
        }

        return cnt+1;
        
    }
}