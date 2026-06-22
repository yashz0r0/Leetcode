// Last updated: 22/06/2026, 23:53:58
class Solution {
    public boolean isHappy(int n) {
      

        StringBuilder sb= new StringBuilder(String.valueOf(n));
          if(n==1)return true;
          HashSet<String> set= new HashSet<>();
       
        while(!set.contains(sb.toString())){
            long ans=0;
            set.add(sb.toString());
            for(int i=0;i<sb.length();i++){
                int digit =sb.charAt(i) - '0';
                ans+=digit*digit;
            }
           sb.replace(0, sb.length(), String.valueOf(ans));
            if(ans==1){
                return true;
            }

        }
     
        return false;
        
    }
}