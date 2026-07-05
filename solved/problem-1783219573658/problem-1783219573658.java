// Last updated: 05/07/2026, 08:16:13
1class Solution {
2    public boolean canMakeSubsequence(String s, String t) {
3        int n=s.length();
4        int m=t.length();
5
6        if(n>m)return false;
7        int i0=0;
8        int i1=0;
9
10        for(int i=0;i<m;i++){
11            char c=t.charAt(i);
12            int ni0=i0;
13            int ni1=i1;
14            if(i0<n&&s.charAt(i0)==c){
15                ni0=Math.max(ni0,i0+1);
16            }
17            if(i0<n&&s.charAt(i1)==c){
18                ni1=Math.max(ni1,i1+1);
19            }
20            if(i0<n)ni1=Math.max(ni1,i0+1);
21            i0=ni0;
22            i1=ni1;
23            if(i1==n)return true;
24            
25        }
26        return false;
27    }
28}