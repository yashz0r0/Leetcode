// Last updated: 22/06/2026, 23:57:44
class Solution {
    public boolean checkGoodInteger(int n) {
        String s=Integer.toString(n);

        long sum=0;
        long sqr=0;

        for(int i=0;i<s.length();i++){
            int num=s.charAt(i)-'0';

            sum+=num;
            sqr+= num*num;
        }


        return sqr-sum>=50;
        
    }
}