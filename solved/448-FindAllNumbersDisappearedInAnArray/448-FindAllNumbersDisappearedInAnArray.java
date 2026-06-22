// Last updated: 22/06/2026, 23:53:08
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n= nums.length;
        List<Integer> list= new ArrayList<>();
        TreeSet<Integer> set= new TreeSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }

        return list;
    }
}