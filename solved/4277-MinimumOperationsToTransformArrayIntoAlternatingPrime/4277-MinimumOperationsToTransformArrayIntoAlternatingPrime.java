// Last updated: 22/06/2026, 23:58:21
class Solution {
    public int minOperations(int[] nums) {
        int max=0;
        for(int x: nums )max=Math.max(max,x);
        int limit=max+100;

        boolean[] isPrime= new boolean[limit+1];
        for(int i=2;i<=limit;i++) isPrime[i]=true;
        
        for(int i=2;i*i<=limit;i++){
            for(int j=i*i;j<=limit;j+=i){
                isPrime[j]=false;
            }
        }
        int ops=0;

        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(i%2==0){
              while(!isPrime[val]){
                  val++;
                  ops++;
              }
            }else{
                while(val>=2&&isPrime[val]){
                    val++;
                    ops++;
                }
              }
            
        }

        return ops;
    }
}