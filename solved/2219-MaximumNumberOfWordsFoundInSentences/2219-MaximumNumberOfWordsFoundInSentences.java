// Last updated: 23/06/2026, 00:02:20
class Solution {
    public int mostWordsFound(String[] sentences) {
        int max=0;

        for(String s: sentences){
            int cnt=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==' ')cnt++;
            }
            max=Math.max(max, cnt+1);
        }


        return max;
    }
}