// Last updated: 22/06/2026, 23:53:30
class Solution {
    public int coinChange(int[] coins, int amount) {
          int n = coins.length;

        int[][] t = new int[n+1][amount+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<amount+1;j++){
                if(j==0) t[i][j]=0;
                if(i==0) t[i][j]=Integer.MAX_VALUE-1;
            }
        }


        for(int j=1;j<amount+1;j++){
            if(j%coins[0]==0){
                t[1][j]= j/coins[0];
            }else{
                t[1][j]=Integer.MAX_VALUE-1;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){

                if(coins[i-1] <= j){
                    t[i][j] = Math.min(t[i-1][j] ,1+t[i][j-coins[i-1]]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

         return (t[n][amount] == Integer.MAX_VALUE-1) ? -1 : t[n][amount];

      
    }
}