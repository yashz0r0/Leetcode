// Last updated: 20/07/2026, 13:18:03
1class Solution {
2    public List<Integer> majorityElement(int[] nums) {
3        int n=nums.length;
4        HashMap<Integer,Integer> map=new HashMap<>();
5
6        for(int num:nums){
7            map.put(num,map.getOrDefault(num,0)+1);
8        }
9        List<Integer> list= new ArrayList<>();
10        for(int key:map.keySet()){
11            if(map.get(key)>n/3)list.add(key);
12        }
13
14        return list;
15    }
16}