// Last updated: 23/06/2026, 00:00:01
class Solution {
    public String reverseWords(String s) {
        String[] words= s.split(" ");
        int count= getcount(words[0]);

        for(int i=1;i<words.length;i++){
            if(count==getcount(words[i]))
             words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        return String.join(" ", words);
        
    }

    public int getcount(String s){
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
}