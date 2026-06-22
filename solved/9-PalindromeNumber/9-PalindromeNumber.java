// Last updated: 22/06/2026, 23:55:11
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int reverse=0;
        int ip=x;

        while(x>0){
            reverse=reverse*10+x%10;
            x=x/10;
        }

        return ip==reverse;
    }
}