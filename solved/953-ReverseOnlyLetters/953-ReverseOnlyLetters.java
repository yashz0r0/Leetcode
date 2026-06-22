// Last updated: 23/06/2026, 00:03:53
class Solution {
    public String reverseOnlyLetters(String s) {
        int n=s.length();
        int i=0;
        int j=n-1;
        char[] ch= s.toCharArray();
        while(i<j){
            if(!Character.isLetter(ch[i])){
                i++;
            } else if(!Character.isLetter(ch[j])){
                j--;
            }else{
                char temp= ch[j];
                ch[j]= ch[i];
                ch[i]= temp;
                i++;
                j--;
            }
          
        }

        return new String(ch);
        
    }
}