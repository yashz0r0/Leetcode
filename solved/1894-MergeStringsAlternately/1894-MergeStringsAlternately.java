// Last updated: 23/06/2026, 00:02:43
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb= new StringBuilder();

        int i=0;
        int j=0;
        int n=word1.length();
        int m= word2.length();

        while(i<n&&j<m){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        while(i<n){
            sb.append(word1.charAt(i++));
        }

        while(j<m){
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
        
        
    }
}