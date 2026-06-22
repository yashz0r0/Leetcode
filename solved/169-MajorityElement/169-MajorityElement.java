// Last updated: 22/06/2026, 23:54:04
class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map= new HashMap<>();

        for(int x:nums){
            map.put(x, map.getOrDefault(x,0)+1);

            if(map.get(x)>nums.length/2){
                return x;
            }
        }

        return -1;
      
    }
}