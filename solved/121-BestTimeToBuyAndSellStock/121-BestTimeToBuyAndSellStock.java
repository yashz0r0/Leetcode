// Last updated: 22/06/2026, 23:54:22
class Solution {
    public int maxProfit(int[] prices) {


        int ans=0;
        int n= prices.length;
        int max=0;
        int buy=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
          
             int curr= prices[i];
             buy = Math.min(buy, curr);
             max= Math.max(max, prices[i]-buy);
        }
        return max;
    }
}