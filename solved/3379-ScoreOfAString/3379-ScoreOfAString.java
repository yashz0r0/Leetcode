// Last updated: 23/06/2026, 00:01:24
class Solution {
    public int scoreOfString(String s) {
        
        int score=0;

        for(int i=1;i<s.length();i++){
            score+= Math.abs((s.charAt(i-1)-'0')-(s.charAt(i)-'0'));
        }
        
        return score;
    }
}