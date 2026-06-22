// Last updated: 23/06/2026, 00:01:18
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i + k <= n; i++) {

            // 1️ Count frequencies in current window
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // 2️ Put elements into list for sorting
            List<int[]> list = new ArrayList<>();
            for (int num : freq.keySet()) {
                list.add(new int[]{num, freq.get(num)});
            }

            // 3️ Sort by frequency desc, value desc
            Collections.sort(list, (a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1]; // freq desc
                return b[0] - a[0];                  // value desc
            });

            // 4️ Take top x elements and sum all their occurrences
            int sum = 0;
            for (int t = 0; t < Math.min(x, list.size()); t++) {
                sum += list.get(t)[0] * list.get(t)[1];
            }

            ans[i] = sum;
        }

        return ans;
    }
}
