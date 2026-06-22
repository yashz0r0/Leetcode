// Last updated: 22/06/2026, 23:57:56
class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        long active=0;

        long start=intervals[0][0];
        long end=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            long s= intervals[i][0];
            long e=intervals[i][1];

            if(s<=end+1){
                end=Math.max(end,e);
            }else{
                active+=end-start+1;
                start=s;
                end=e;
            }
            
        }

        active+=end-start+1;


        return ((brightness+2L)/3)*active;
    }
}