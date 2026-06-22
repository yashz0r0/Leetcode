// Last updated: 22/06/2026, 23:58:54
class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {

        int min= Integer.MAX_VALUE;
        int idx=-1;

        for(int i=0;i<capacity.length; i++){
            if(capacity[i]>=itemSize&&min>capacity[i]){
                min=capacity[i];
                 idx=i;
            }
        }
        return idx;
    }
}