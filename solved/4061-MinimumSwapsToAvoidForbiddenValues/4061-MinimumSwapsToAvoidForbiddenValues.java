// Last updated: 23/06/2026, 00:00:48
class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {
         int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> badPairs = new HashMap<>();

       
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            freq.put(forbidden[i], freq.getOrDefault(forbidden[i], 0) + 1);

            if (nums[i] == forbidden[i]) {
                badPairs.put(nums[i], badPairs.getOrDefault(nums[i], 0) + 1);
            }
        }

  
        for (int v : freq.values()) {
            if (v >= n + 1) {
                return -1;
            }
        }

        int badPairsSum = 0;
        int maxBadPairs = 0;

        for (int cnt : badPairs.values()) {
            badPairsSum += cnt;
            maxBadPairs = Math.max(maxBadPairs, cnt);
        }

     
        return Math.max((badPairsSum + 1) / 2, maxBadPairs);
    }

   
}