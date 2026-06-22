// Last updated: 22/06/2026, 23:53:20
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res= new ArrayList<>();
        Map<Integer,Integer> map= new HashMap<>();
        for(int num:nums1)map.put(num,map.getOrDefault(num, 0)+1);
        for(int num:nums2)
          if(map.containsKey(num)){
            map.put(num,map.get(num)-1);
            res.add(num);
            if(map.get(num)==0) map.remove(num);
          }
          int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++)result[i] = res.get(i);
        return result;        
    }
}