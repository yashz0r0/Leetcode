// Last updated: 01/10/2026, 18:54:08
1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> st = new Stack<>();
4        
5        for (char c : s.toCharArray()) {
6           
7            if (c == '(' || c == '[' || c == '{') {
8                st.push(c);
9            } 
10          
11            else {
12               
13                if (st.isEmpty()) return false;
14                
15                char top = st.pop();
16                if (c == ')' && top != '(') return false;
17                if (c == ']' && top != '[') return false;
18                if (c == '}' && top != '{') return false;
19            }
20        }
21
22      
23        return st.isEmpty();
24    }
25}