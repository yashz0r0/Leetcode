// Last updated: 22/06/2026, 23:53:14
class Solution {
    public boolean isSubsequence(String s, String t) {
        int j=0;
        int n=s.length();
        int m=t.length();

        for(int i=0;i<m;i++){
            if(j<n&&s.charAt(j)==t.charAt(i))j++;
            
        }
        return j==n;
    }
}