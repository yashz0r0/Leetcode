// Last updated: 22/06/2026, 23:59:23
class Solution {
    public int minOperations(int[] nums, int[] target) {
        int n= nums.length;
        Set<Integer> set= new HashSet<>();

        for(int i=0;i<n;i++){
            if(nums[i]!=target[i]){
                set.add(nums[i]);
            }
        }



        return set.size();
        
        
    }
}