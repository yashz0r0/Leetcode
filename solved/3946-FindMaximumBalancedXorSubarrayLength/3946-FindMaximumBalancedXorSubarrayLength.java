// Last updated: 23/06/2026, 00:01:05
class Solution {
    public int maxBalancedSubarray(int[] nums) {
        int n= nums.length;
        Map<String, Integer> map= new HashMap<>();
        int prefXor= 0;
        int diff=0;
        int res=0;
        map.put("0+0",-1);
        for(int i=0;i<n;i++){
            prefXor^= nums[i];
            if((nums[i]&1)==0) diff++;
            else diff--;

            String key = prefXor+"+"+diff;

            if(map.containsKey(key)){
                res=Math.max(res,i-map.get(key));
            }else {
                map.put(key,i);
                }
            }
        

    return res;
    }
}