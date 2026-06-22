// Last updated: 22/06/2026, 23:54:16
class Solution {
    public int singleNumber(int[] nums) {

        HashSet<Integer> set= new HashSet<>();

        for(int x:nums){
            if(set.contains(x)){
                set.remove(x);
            }else{
                set.add(x);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        return list.get(0);
        
    }
}