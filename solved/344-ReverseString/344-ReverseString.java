// Last updated: 22/06/2026, 23:53:25
class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st= new Stack<>();

        for(int i=0;i<s.length;i++){
            st.push(s[i]);
        }

        for(int i=0;i<s.length;i++){
            s[i]=st.pop();
        }
        
    }
}