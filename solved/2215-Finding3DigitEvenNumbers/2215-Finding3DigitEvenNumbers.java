// Last updated: 23/06/2026, 00:02:22
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; 

            for (int j = 0; j < n; j++) {
                if (j == i) continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    if (digits[k] % 2 == 0) { 
                        int num = digits[i]*100 + digits[j]*10 + digits[k];
                        set.add(num);
                    }
                }
            }
        }

        int[] res = new int[set.size()];
        int idx = 0;
        for (int x : set) res[idx++] = x;

        Arrays.sort(res);
        return res;
    }
}
