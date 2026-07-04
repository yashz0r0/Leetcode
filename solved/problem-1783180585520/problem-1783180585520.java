// Last updated: 04/07/2026, 21:26:25
1class Solution {
2    public int minOperations(String s1, String s2) {
3        int n=s1.length();
4        int[] dp= new int[2];
5            dp[0]=Integer.MAX_VALUE;
6        dp[1]=Integer.MAX_VALUE;
7        dp[s1.charAt(0)-'0']=0;
8        for(int i=0;i<n;i++){
9            int[] sdp=new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
10            int t=s2.charAt(i)-'0';
11            int N=(i<n-1)?(s1.charAt(i+1)-'0'):0;
12            for(int j=0;j<2;j++){
13                if(dp[j]==Integer.MAX_VALUE) continue;
14                if(!(j==1&&t==0)){
15                    int ca=(j==0&&t==1)?1:0;
16                    sdp[N]=Math.min(sdp[N],dp[j]+ca);
17                }
18
19                if(i<n-1){
20                    int cb=(j==0?1:0)+(N==0?1:0)+1;
21                    if(t==1)cb++;
22                    sdp[0]=Math.min(sdp[0],dp[j]+cb);
23                }
24            }
25            dp=sdp;
26        }
27       return dp[0]==Integer.MAX_VALUE?-1:dp[0];
28    }
29    
30}