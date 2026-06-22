// Last updated: 22/06/2026, 23:58:58
class Solution {
    public long gcdSum(int[] nums) {

        int n=nums.length;

        int[] pref= new int[n];

        int max=0;


        for(int i=0;i<n;i++){
            max= Math.max(max, nums[i]);
            pref[i]=gcd(nums[i],max);
        }
        Arrays.sort(pref);

        int i=0;
        int j=n-1;
        long sum=0;

        while(i<j){
            sum+=gcd(pref[i],pref[j]);
            i++;
            j--;
        }

        return sum;
        

        
    }


    private int gcd(int a, int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }

        return a;
    }
}