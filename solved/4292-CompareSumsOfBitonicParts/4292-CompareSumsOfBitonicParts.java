// Last updated: 22/06/2026, 23:57:59
class Solution {
    public int compareBitonicSums(int[] nums) {

        int n = nums.length;

        int idx = 0;

  
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) idx = i;
            else break;
        }

        long asc = 0, desc = 0;

  
        for (int i = 0; i <= idx; i++) {
            asc += nums[i];
        }

    
        for (int i = idx; i < n; i++) {
            desc += nums[i];
        }

        if (asc > desc) return 0;
        if (desc > asc) return 1;
        return -1;
    }
}