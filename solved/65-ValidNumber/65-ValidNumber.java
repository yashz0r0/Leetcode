// Last updated: 13/07/2026, 22:56:26
1class Solution {
2    public boolean isNumber(String s) 
3    {
4        boolean e = false;
5        boolean dot = false;
6        boolean n=false;
7        for(int i=0;i<s.length();i++)
8        {
9            if(Character.isDigit(s.charAt(i)))
10            n=true;
11            else 
12            if(s.charAt(i)=='e'||s.charAt(i)=='E')
13            {
14                if(e||!n)
15                return false;
16                e = true;
17                n = false;
18            }
19            else 
20            if(s.charAt(i)=='.')
21            {
22                if(dot||e)
23                return false;
24                dot=true;
25            }
26            else if(s.charAt(i)=='-'||s.charAt(i)=='+')
27            {
28                if(i!=0&&s.charAt(i-1)!='e'&&s.charAt(i-1)!='E')
29                return false;
30            }
31            else
32            return false;
33        }
34        return n;
35    }
36}