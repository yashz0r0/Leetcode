// Last updated: 23/06/2026, 00:00:08
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(need1==0&&need2==0) return 0;
        long ans=Long.MAX_VALUE;
        long[] arr=new long[]{
            0,Math.min(need1, need2), Math.max(need1,need2)
        };

            for(long x:arr){
    long cost= x*costBoth+Math.max(0L, need1-x)*cost1+Math.max(0L, need2-x)*cost2;
    ans= Math.min(ans, cost);
            }

return ans;
    }
}