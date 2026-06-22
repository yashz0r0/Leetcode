// Last updated: 22/06/2026, 23:59:06
class Solution {
    public boolean isDigitorialPermutation(int n) {

        int digits[]={
            1,2,145,40558
        };

        String s=String.valueOf(n);
        char[] c= s.toCharArray();
        Arrays.sort(c);
        s= new String(c);


        for(int num:digits){
            String st=String.valueOf(num);
            char[] ch= st.toCharArray();
            Arrays.sort(ch);
            st= new String(ch);

            if(st.equals(s)){
                return true;
            }
        }

        return false;
    }
}