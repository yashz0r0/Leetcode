// Last updated: 15/08/2026, 21:44:09
1class Solution {
2    public int elevatorRequests(int n, int[] requests) {
3        int ans=Math.abs(requests[0]-0);
4        for(int i=1;i<requests.length;i++){
5           ans+=Math.abs(requests[i]-requests[i-1]);
6        }
7
8        return ans;
9        
10    }
11}