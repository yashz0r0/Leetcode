// Last updated: 23/06/2026, 00:02:45
class Solution {
    public int minOperations(String s) {

        int n = s.length();
        
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(s);

        int cnt = 0;
        int cnt2 = 0;

        sb.setCharAt(0, '0');
        sb2.setCharAt(0, '1');

        if(s.charAt(0) != '0') cnt++;
        if(s.charAt(0) != '1') cnt2++;

       
        for(int i = 1; i < n; i++){
            char prev = sb.charAt(i-1);

            if(sb.charAt(i) == prev){
                if(prev == '0') sb.setCharAt(i,'1');
                else sb.setCharAt(i,'0');
                cnt++;
            }
        }

      
        for(int i = 1; i < n; i++){
            char prev = sb2.charAt(i-1);

            if(sb2.charAt(i) == prev){
                if(prev == '0') sb2.setCharAt(i,'1');
                else sb2.setCharAt(i,'0');
                cnt2++;
            }
        }

        return Math.min(cnt, cnt2);
    }
}