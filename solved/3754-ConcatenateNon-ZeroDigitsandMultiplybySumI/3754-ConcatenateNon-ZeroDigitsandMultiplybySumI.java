// Last updated: 21/07/2026, 13:21:50
1class Solution {
2    public long sumAndMultiply(int n) {
3        String s= String.valueOf(n);
4        StringBuilder sb= new StringBuilder();
5      long sum=0;
6
7        for(int i=0;i< s.length();i++){
8            if(s.charAt(i)!='0'){
9                sb.append(s.charAt(i));
10                sum+=s.charAt(i)-'0';
11            }
12        }
13        if(sb.length() ==0) return 0;
14        String st= sb.toString();
15
16        return Long.parseLong(st)*sum;
17        
18    }
19}