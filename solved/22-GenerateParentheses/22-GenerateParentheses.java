// Last updated: 28/07/2026, 08:29:44
1class Solution {
2    public List<String> generateParenthesis(int n) {
3
4        List<String> list= new ArrayList<>();
5
6        solve(n,n,"",list);
7
8        return list;
9        
10    }
11
12    public void solve(int n,int m, String op,List<String> list){
13        if(n==0&&m==0){
14            list.add(op);
15            return;
16        }
17
18        if(n!=0){
19            String op1=op+'(';
20            solve(n-1,m,op1,list);
21        }
22        if(n<m){
23            String op2=op+')';
24            solve(n,m-1,op2,list);
25        }
26    }
27}