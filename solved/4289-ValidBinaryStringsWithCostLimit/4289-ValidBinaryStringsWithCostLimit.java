// Last updated: 22/06/2026, 23:58:03
class Solution {
    public List<String> generateValidStrings(int n, int k) {
        solve(0, n, k, 0, new StringBuilder());
       return ans;
        
    }

      List<String> ans= new ArrayList<>();
        public void solve(int idx,int n, int k,int cost, StringBuilder s){
            if(idx==n){
                ans.add(s.toString());
                return;
            }

            s.append('0');
            solve(idx+1,n,k,cost,s);
            s.deleteCharAt(s.length()-1);

            if((s.length()==0||s.charAt(s.length()-1)!='1') && cost+idx<=k){
                s.append('1');
                solve(idx+1,n,k,cost+idx, s);
                s.deleteCharAt(s.length()-1);
            }
        }
}