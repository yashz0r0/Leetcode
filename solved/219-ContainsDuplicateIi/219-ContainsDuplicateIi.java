// Last updated: 22/06/2026, 23:53:48
import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;

        if (n == 1) return false;

        Set<Integer> set = new HashSet<>();

        while (j < n) {

            if (set.contains(nums[j])) {
                return true;
            }

            set.add(nums[j]);

           
            if (j - i >= k) {
                set.remove(nums[i]);
                i++;
            }

            j++;
        }

        return false;
    }
}