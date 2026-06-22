// Last updated: 22/06/2026, 23:53:49
class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set= new HashSet<>();

        for(int x:nums){
            if(set.contains(x))return true;
            set.add(x);
        }
        return false;
    }
}