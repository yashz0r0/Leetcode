// Last updated: 22/06/2026, 23:52:56
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int cnt=0;
        Map<Integer,Integer> map= new HashMap<>();
        map.put(0,1);

        for(int x: nums){
            sum+=x;

            if(map.containsKey(sum-k)){
                cnt+= map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return cnt;
    }
}