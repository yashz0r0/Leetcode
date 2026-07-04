// Last updated: 04/07/2026, 20:33:41
1class Solution {
2    private int[][][][] dp;
3    private int mod=1_000_000_007;
4    String word1;
5    String word2;
6    String target;
7    public int interleaveCharacters(String word1, String word2, String target) {
8        this.word1=word1;
9        int n=word1.length();
10        int m=word2.length();
11        int t=target.length();
12        
13        this.word2=word2;
14        this.target=target;
15        dp= new int[n+1][m+1][t][4];
16
17
18        for(int i=0;i<=n;i++){
19            for(int j=0;j<=m;j++){
20                for(int k=0;k<t;k++){
21                     dp[i][j][k][0]=-1;
22                     dp[i][j][k][1]=-1;
23                     dp[i][j][k][2]=-1;
24                     dp[i][j][k][3]=-1;
25                }
26            }
27        }
28
29        return solve(0,0,0,0);
30    }
31
32    public int solve(int i,int j, int k, int mask){
33        if(k==target.length()){
34            return mask==3?1:0;
35        }
36        if(dp[i][j][k][mask]!=-1){
37            return dp[i][j][k][mask];
38        }
39        int ways=0;
40        char ec=target.charAt(k);
41
42        for(int I=i;I<word1.length();I++){
43            if(word1.charAt(I)==ec){
44                ways=(ways+solve(I+1,j,k+1,mask|1))%mod;
45            }
46        }
47        for(int J=j;J<word2.length();J++){
48            if(word2.charAt(J)==ec){
49                ways=(ways+solve(i,J+1,k+1,mask|2))%mod;
50            }
51        }
52
53        return dp[i][j][k][mask]=ways;
54        
55    }
56}