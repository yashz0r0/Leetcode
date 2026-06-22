// Last updated: 23/06/2026, 00:03:34
class Solution {
    public int maxNumberOfBalloons(String text) {
        int b=0;
        int a=0;
        int l=0;
        int o=0;
        int n=0;

        for(char ch:text.toCharArray()){
            if(ch=='b')b++;
            if(ch=='a')a++;
            if(ch=='l')l++;
            if(ch=='o')o++;
            if(ch=='n')n++;
        }
        l=l/2;
        o=o/2;

        return Math.min(Math.min(Math.min(b,a), Math.min(l,o)),n);




    }
}