// Last updated: 23/06/2026, 00:02:49
class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int max=0;

        int prefix=0;


        for(int i=0;i<n;i++){
            prefix=prefix+gain[i];
            max= Math.max(max, prefix);
        }

        return max;
              
    }
}