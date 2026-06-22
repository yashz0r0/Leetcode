// Last updated: 23/06/2026, 00:02:16
class Solution {
    public int numberOfBeams(String[] bank) {
        int m=bank.length;
        int n=bank[0].length();
        int ans=0;
        int curr=0;

        for(int i=0;i<m;i++){
            int cnt=0;
            for(char c:bank[i].toCharArray()){
                if(c=='1')cnt++;   
            }
               ans+=curr*cnt;
                if(cnt!=0)curr=cnt;
        }
        return ans;
    }
}