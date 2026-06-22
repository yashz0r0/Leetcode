// Last updated: 22/06/2026, 23:59:04
class Solution {
    public String trimTrailingVowels(String s) {
        int n= s.length();
        StringBuilder sb= new StringBuilder(s);

       while(sb.length()>0&&isVowel(sb.charAt(sb.length()-1))){
           sb.deleteCharAt(sb.length()-1);
       }
        return sb.toString();
    }

    public boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }else{
            return false;
        }
    }
}