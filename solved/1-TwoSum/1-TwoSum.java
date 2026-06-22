// Last updated: 22/06/2026, 23:55:18
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int compliment=target-nums[i];
            if(map.containsKey(compliment)){
                return new int[]{i, map.get(compliment)};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}