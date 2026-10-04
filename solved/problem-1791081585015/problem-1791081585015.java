// Last updated: 04/10/2026, 08:09:45
1class Solution {
2
3    int cost(int a , int b){
4        int d=Math.abs(a-b);
5        return Math.min(d,10-d);
6    }
7    public int minRotations(int n, String s) {
8        int total=cost(0,s.charAt(0)-'0');
9
10        for(int i=1;i<n;i++)total+=cost(s.charAt(i-1)-'0',s.charAt(i)-'0');
11
12        int ans=total;
13
14        for(int k=0;k<n;k++){
15            int prev=(k==0)?0:s.charAt(k-1)-'0';
16            int first=s.charAt(k)-'0';
17            int last=s.charAt(n-1)-'0';
18
19            ans=Math.min(ans,total-cost(prev,first)+cost(prev,last));
20        }
21
22        return ans;
23    }
24}