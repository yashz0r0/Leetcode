// Last updated: 23/06/2026, 00:00:13
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map= new HashMap<>();
        int dist=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
       
            if(map.containsKey(nums[i])){
                dist= Math.min(dist, i-map.get(nums[i]));
            }
                 int rev= reverse(nums[i]);
            map.put(rev,i);
        }

        return dist==Integer.MAX_VALUE ? -1:dist;
    }

    public int reverse(int x){
        int rev=0;
        while(x>0){
            rev= rev*10+x%10;
            x/=10;
        }

        return rev;
    }
}