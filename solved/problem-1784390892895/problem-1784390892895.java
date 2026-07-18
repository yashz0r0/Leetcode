// Last updated: 18/07/2026, 21:38:12
1class Solution {
2    public String rearrangeString(String s, char x, char y) {
3        int xc=0;
4        StringBuilder sb=new StringBuilder();
5
6        for(char c:s.toCharArray()){
7            if(c==x)xc++;
8            else sb.append(c);
9        }
10
11        for(int i=0;i<xc;i++){
12            sb.append(x);
13        }
14
15        return sb.toString();
16        
17    }
18}