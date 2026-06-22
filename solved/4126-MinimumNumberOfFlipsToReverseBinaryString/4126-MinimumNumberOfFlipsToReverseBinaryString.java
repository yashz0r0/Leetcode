// Last updated: 23/06/2026, 00:00:24
class Solution {
    public int minimumFlips(int n) {
    
       
        String s = Integer.toBinaryString(n);
        int flip=0;
        int l=0, r= s.length()-1;

        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                flip+=2;
  
            }
            l++;
            r--;
        }


        return flip;

            
    }
}