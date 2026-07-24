// Last updated: 24/07/2026, 20:55:08
1class Solution {
2    public int maximum69Number (int num) {
3        StringBuilder sb = new StringBuilder();
4        sb.append(num);
5
6        for(int i=0;i<sb.length();i++){
7            if(sb.charAt(i)=='6'){
8                sb.setCharAt(i,'9');
9                break;
10            }
11        }
12
13
14        return Integer.parseInt(sb.toString());
15        
16    }
17}