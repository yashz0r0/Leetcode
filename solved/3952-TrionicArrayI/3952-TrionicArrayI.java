// Last updated: 23/06/2026, 00:01:03
class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false; 
        int i = 0;

  
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;
        if (i == 0 || i == n - 1) return false;

        int decStart = i;
        while (i + 1 < n && nums[i] > nums[i + 1]) i++;
        if (i == decStart || i == n - 1) return false;

  
        int inc2Start = i;
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;
        if (i == inc2Start) return false;

     
        return i == n - 1;
    }
}
