// Last updated: 22/06/2026, 23:53:23
class Solution {
    public String reverseVowels(String s) {
        int i=0;
        int j=s.length()-1;
        char[] ch= s.toCharArray();


        while(i<j){
            if (!isVowel(ch[i])) {
                i++;
            } else if (!isVowel(ch[j])) {
                j--;
            } else {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
        }
        return new String(ch);
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'A' ||
               c == 'e' || c == 'E' ||
               c == 'i' || c == 'I' ||
               c == 'o' || c == 'O' ||
               c == 'u' || c == 'U';
    }
}