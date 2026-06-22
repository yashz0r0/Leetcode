// Last updated: 22/06/2026, 23:59:20
class Solution {

    long[] prefix;
    String s;
    int encCost, flatCost;

    public long minCost(String s, int encCost, int flatCost) {

      this.encCost= encCost;
      this.flatCost= flatCost;
      this.s= s;

      int n = s.length();

      prefix= new long[n+1];

      for(int i=0;i<n;i++){
        prefix[i+1]=prefix[i]+(s.charAt(i)-'0');
      }


      return solve(0,n-1);

    }

    private long solve(int l, int r){
        int len=r-l+1;

        long ones= prefix[r+1]-prefix[l];
        long nosplit= 0;

        if(ones==0){
            nosplit=flatCost;
        }else{
            nosplit=(long)len*ones*encCost;
        }

        if(len%2!=0) return nosplit;

        int mid= (r+l)/2;


        long split= solve(l,mid)+solve(mid+1,r);


        return Math.min(split,nosplit);

        
    }
}