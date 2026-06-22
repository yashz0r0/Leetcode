// Last updated: 22/06/2026, 23:59:27
class Solution {
    public int residuePrefixes(String s) {
        int n= s.length();
        int max=0;
        int cnt=0;

        Set<Character> set = new HashSet<>();
        for(int i=0;i<n;i++){
            
            set.add(s.charAt(i));
            int distinct = set.size();
            int mod = (i + 1) % 3;

            if (distinct == mod) {
                cnt++;
            }
          
        }

        return cnt;
    }
}