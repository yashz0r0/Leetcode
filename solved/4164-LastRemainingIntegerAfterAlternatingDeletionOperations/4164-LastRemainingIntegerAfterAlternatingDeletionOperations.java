// Last updated: 22/06/2026, 23:59:48
class Solution {
    public long lastInteger(long n) {
        long h=1;
        long t=n;
        long step=1;
        long rem=n;
        boolean ltr=true;

        while(rem>1){
        
            if(ltr||rem%2==1){
                t-=step;
            }else{
                h+=step;
            }
            rem=(rem+1)/2;
            step=step*2;
            ltr=!ltr;
        }
        return h;
    }
}