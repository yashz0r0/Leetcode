// Last updated: 27/09/2026, 18:47:06
1class Solution {
2    public String reverseParentheses(String s) {
3        Stack<Integer> st= new Stack<>();
4        StringBuilder res= new StringBuilder();
5
6        for(int i=0;i<s.length();i++){
7            char ch=s.charAt(i);
8
9            if(ch=='('){
10                st.push(res.length());
11            }else if(ch==')'){
12                int start=st.pop();
13                int end=res.length()-1;
14                reverse(res,start,end);
15            }else{
16                res.append(ch);
17            }
18        }
19        return res.toString();
20
21    }
22    public void reverse(StringBuilder sb,int start,int end) {
23        while(start < end) {
24            char temp = sb.charAt(start);
25            sb.setCharAt(start,sb.charAt(end));
26            sb.setCharAt(end,temp);
27            start++;
28            end--;
29        }
30    }
31}