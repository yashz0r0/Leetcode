// Last updated: 23/06/2026, 00:02:52
class Solution {
    public int maxOperations(int[] nums, int k) {
        int n= nums.length;
        Map<Integer, Integer> map = new HashMap<>(); 
        int count=0;

        for(int i=0;i<n;i++){
            int complement= k-nums[i];
            if(map.containsKey(complement)){
                 map.put(complement, map.get(complement) - 1);
                if (map.get(complement) == 0) {
                    map.remove(complement);
                }
                count++;
            }else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }

        return count;
        
    }
}