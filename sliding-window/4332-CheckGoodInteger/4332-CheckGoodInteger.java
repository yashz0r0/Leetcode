// Last updated: 23/06/2026, 00:12:36
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