// Last updated: 19/07/2026, 08:02:34
1class Solution {
2    public boolean canReach(int[] st, int[] tar) {
3
4        return ((st[0]+st[1])&1)==((tar[0]+tar[1])&1);
5        
6    }
7}