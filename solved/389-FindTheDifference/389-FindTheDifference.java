// Last updated: 22/06/2026, 23:53:16
class Solution {
    public char findTheDifference(String s, String t) {
        char[] ch1= s.toCharArray();
        char[] ch2= t.toCharArray();

        if(s.length()==0) return t.charAt(0);

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for(int i=0;i<s.length();i++){
            if(ch1[i]!=ch2[i]){
                return ch2[i];
            }
        }

        
        return ch2[t.length()-1];
    }
}