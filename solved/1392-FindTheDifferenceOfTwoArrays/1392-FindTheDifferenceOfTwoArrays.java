// Last updated: 23/06/2026, 00:03:28
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
         Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();


        for (int x : nums1) set1.add(x);
        for (int x : nums2) set2.add(x);

        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();

        for (int x : set1) {
            if (!set2.contains(x)) {
                ans1.add(x);
            }
        }

  
        for (int x : set2) {
            if (!set1.contains(x)) {
                ans2.add(x);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(ans1);
        result.add(ans2);

        return result;
        
        
    }
}