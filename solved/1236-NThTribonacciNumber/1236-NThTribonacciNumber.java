// Last updated: 23/06/2026, 00:03:37
class Solution {
    public int tribonacci(int n) {

        if(n==0) return 0;

        if(n==1) return 1;
        if(n==2) return 1;
        int t[] = new int[n+1];

        

        t[0]=0;
        t[1]=1;
        t[2]=1;


        for(int i=3;i<n+1;i++){
            t[i]=t[i-1]+t[i-2]+t[i-3];
        }
        

        return t[n];
    }
}