// Last updated: 23/06/2026, 00:02:14
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        int n=asteroids.length;
        long max=mass *1L;

        for(int i=0;i<n;i++){
            if(max>=asteroids[i]){
                max+=asteroids[i];
            }else{
                return false;
            }
        }


        return true;
    }
}