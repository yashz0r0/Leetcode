// Last updated: 23/06/2026, 00:01:01
class Solution {
    public String mergeCharacters(String s, int k) {

        StringBuilder sb= new StringBuilder(s);

       

        while(true){
            boolean merged=false;

            for(int i=0;i<sb.length();i++){
                for(int j=i+1;j<sb.length();j++){
                    if(sb.charAt(i)==sb.charAt(j)){
                        if(j-i<=k){
                            sb.deleteCharAt(j);
                            merged=true;
                            break;
                        }
                    }
                }
                if(merged)break;
            }
            if(!merged) break;
        }
        
       return sb.toString(); 
    }
}