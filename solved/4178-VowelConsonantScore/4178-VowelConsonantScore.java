// Last updated: 22/06/2026, 23:59:36
class Solution {
    public int vowelConsonantScore(String s) {

        int v=0;
        int c=0;
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)>='a'&&s.charAt(i)<='z')
            if(s.charAt(i)=='a'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='e'||s.charAt(i)=='u'){
                v++;
            }else{
                c++;
            }
        }
        if(c==0||v==0) return 0;


        return v/c;
        
    }
}