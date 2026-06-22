// Last updated: 23/06/2026, 00:00:54
class Solution {
    public String maximumXor(String s, String t) {
        int zero=0;
        int one=0;
        for(int i=0;i<s.length();i++){
         if(t.charAt(i)=='0'){
             zero++;
         }else{
             one++;
         }
        }

            StringBuilder sb= new StringBuilder();

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    if(one>0){
                        sb.append('1');
                        one--;
                    }else{
                        sb.append('0');
                        zero--;
                    }
                }else{
                     if(zero>0){
                          sb.append('1');
                        zero--;
                    }else{
                      
                         sb.append('0');
                        one--;
                    }
                }
            }

                return sb.toString();
            
        

        
        
    }
}