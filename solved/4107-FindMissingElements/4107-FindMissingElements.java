// Last updated: 23/06/2026, 00:00:31
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        Set<Integer> set= new HashSet<>();
        
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        List<Integer> list= new ArrayList<>();

        for(int i=nums[0];i<nums[n-1];i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
        
    }
}