// Last updated: 22/06/2026, 23:57:53
class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
       Map<Integer,Integer> map= new TreeMap<>();
       for(int x:nums) map.put(x, map.getOrDefault(x,0)+1);

       List<Integer> list= new LinkedList<>();
       for(int num:map.keySet()){
        int lim= Math.min(k,map.get(num));

        for(int i=0;i<lim;i++){
            list.add(num);
        }
        
       }
      
        return  list.stream().mapToInt(Integer::intValue).toArray();
    }
}