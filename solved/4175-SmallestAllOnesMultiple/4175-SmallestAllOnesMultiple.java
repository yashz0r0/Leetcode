// Last updated: 22/06/2026, 23:59:41
class Solution {
    public int minAllOneMultiple(int k) {
        if(k%2==0||k%5==0) return -1;
        int rem=0;
        int count=0;

        for(int i=1;i<=k;i++){
            count++;
            rem=(rem*10+1)%k;

            if(rem==0)return count;
        }

        return -1;
    }
}