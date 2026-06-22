// Last updated: 23/06/2026, 00:01:19
class Solution {
    public char kthCharacter(int k) {
        if(k==1){
            return 'a';
        }
        int len=1;

        while(len<k){
            len*=2;
        }

        int mid= len/2;

        if(k<=mid){
            return kthCharacter(k);
        }else{
            int prev=kthCharacter(k-mid);

            return (char)((prev-'a'+1)%26+'a'); 
        }
    }
}