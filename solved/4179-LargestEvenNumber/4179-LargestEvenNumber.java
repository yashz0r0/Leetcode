// Last updated: 22/06/2026, 23:59:34
class Solution {
    public String largestEven(String s) {

        int n=s.length();

        int idx=-1;

        for(int i=n-1;i>=0;i--){
            int m=s.charAt(i)-'0';
           
            if(m%2==0){
                 idx=i;
                  break;
            }
        }
        return s.substring(0,idx+1);
    }
}