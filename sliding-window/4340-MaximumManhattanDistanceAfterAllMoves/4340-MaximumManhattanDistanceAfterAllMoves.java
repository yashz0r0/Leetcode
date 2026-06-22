// Last updated: 23/06/2026, 00:12:34
class Solution {
    public int maxDistance(String moves) {
        int x=0;
        int y=0;
        int n=moves.length();
        int tot=0;

        for(int i=0;i<n;i++){
            char ch=moves.charAt(i);
            if(ch=='L')x--;
            if(ch=='R')x++;
            if(ch=='U')y++;
            if(ch=='D')y--;
            if(ch=='_')tot++;
            
        }

        return Math.abs(x)+Math.abs(y)+tot;
        
    }
}