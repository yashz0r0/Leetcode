// Last updated: 22/06/2026, 23:55:04
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
           
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } 
          
            else {
               
                if (st.isEmpty()) return false;
                
                char top = st.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

      
        return st.isEmpty();
    }
}