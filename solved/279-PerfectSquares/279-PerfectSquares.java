// Last updated: 22/06/2026, 23:53:35
class Solution {
    public int numSquares(int n) {
        Callable<Integer>c=()->{
           int w= (int)Math.sqrt(n);

        int[] sq= new int[w];
        for(int i=1;i<=w;i++){

            sq[i-1]=i*i;
        }


        int dp[][]= new int[w+1][n+1];

        for(int i=0;i<=w;i++){

            for(int j=0;j<=n;j++){
                if(j==0) dp[i][j]=0;
                else if(i==0) dp[i][j]= Integer.MAX_VALUE-1;
            }
        }


        for(int i=1;i<=w;i++){
            for(int j=1;j<=n;j++){
                if(sq[i-1]<=j){
                    dp[i][j]=Math.min(1+dp[i][j-sq[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[w][n];
        };
        try{
           FutureTask<Integer> task = new FutureTask<>(c);
            Thread t = new Thread(task);
            t.start();

            return task.get(); 
        }catch(Exception e){}
        return -1;
    }

        
    
}