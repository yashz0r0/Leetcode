// Last updated: 19/07/2026, 08:29:40
1class Solution {
2    public int minimumGroups(String[] w) {
3        Set<String> set=new HashSet<>();
4        for(String x:w){
5            StringBuilder e=new StringBuilder();
6            StringBuilder o=new StringBuilder();
7            for(int i=0;i<x.length();i++){
8                if(i%2==0)e.append(x.charAt(i));
9                else o.append(x.charAt(i));
10            }
11            set.add(min(e.toString())+min(o.toString()));
12        }
13        return set.size();
14    }
15
16    public String min(String s){
17        int n=s.length();
18        if(n<2)return s;
19        String t=s+s;
20        int i=0,j=1,k=0;
21        while(i<n&&j<n&&k<n){
22            char a=t.charAt(i+k), b=t.charAt(j+k);
23            if(a==b)k++;
24            else{
25                if(a>b)i+=k+1;
26                else j+=k+1;
27                if(i==j)j++;
28                k=0;
29            }
30        }
31        return t.substring(Math.min(i,j),Math.min(i,j)+n);
32    }
33}