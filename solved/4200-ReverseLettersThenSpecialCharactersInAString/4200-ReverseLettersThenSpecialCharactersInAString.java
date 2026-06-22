// Last updated: 22/06/2026, 23:59:17
class Solution {
    public String reverseByType(String s) {

        int n=s.length();
        char ch[]= s.toCharArray();
        int i=0;
        int j=n-1;
        while(i<j){
            if(!Character.isAlphabetic(ch[i])){
                i++;
            }else if(!Character.isAlphabetic(ch[j])){
                j--;
                
            }else{
                char temp= ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;
                j--;
            }
        }
         i=0;
         j=n-1;
        while(i<j){
            if(Character.isAlphabetic(ch[i])){
                i++;
            }else if(Character.isAlphabetic(ch[j])){
                j--;
                
            }else{
                char temp= ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;
                j--;
            }
        }

        return new String(ch);
        
    }
}