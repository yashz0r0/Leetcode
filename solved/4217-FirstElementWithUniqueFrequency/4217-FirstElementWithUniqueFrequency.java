// Last updated: 22/06/2026, 23:59:11
class Solution {
    public int firstUniqueFreq(int[] nums) {

        Map<Integer,Integer> map = new LinkedHashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer,Integer> map2 = new LinkedHashMap<>();

        for(int num : map.values()){
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

       
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(map2.get(freq) == 1){
                return key;
            }
        }

        return -1;
    }
}
