// Last updated: 22/06/2026, 23:59:50
class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int idx=n;
        Set<Integer> set= new HashSet<>();

        for(int i=n-1;i>=0;i--){
            if(set.contains(nums[i])){
                break;
            }
            set.add(nums[i]);
            idx=i;
        }

        return (idx+2)/3;
        
    }

   
}