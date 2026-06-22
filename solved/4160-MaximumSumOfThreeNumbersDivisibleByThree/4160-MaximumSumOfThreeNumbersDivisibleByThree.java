// Last updated: 22/06/2026, 23:59:53
class Solution {
    public int maximumSum(int[] nums) {
       List<Integer> r0= new ArrayList<>();
       List<Integer> r1= new ArrayList<>();
       List<Integer> r2= new ArrayList<>();


        for(int x:nums){
            if(x%3==0) r0.add(x);
            else if(x%3==1) r1.add(x);
            else r2.add(x);
        }
        r0.sort(Collections.reverseOrder());
        r1.sort(Collections.reverseOrder());
        r2.sort(Collections.reverseOrder());


        int ans=0;

        if(r0.size()>=3){
            ans= Math.max(ans, r0.get(0)+r0.get(1)+r0.get(2));
        }
         if(r1.size()>=3){
            ans= Math.max(ans, r1.get(0)+r1.get(1)+r1.get(2));
        }
         if(r2.size()>=3){
            ans= Math.max(ans, r2.get(0)+r2.get(1)+r2.get(2));
        }
         if(r0.size()>=1&&r1.size()>=1&&r2.size()>=1){
            ans= Math.max(ans, r0.get(0)+r1.get(0)+r2.get(0));
        }

        return ans;
    }
}