// Last updated: 23/06/2026, 00:03:11
class Solution {
    public boolean hasAllCodes(String s, int k) {
         int n = s.length();
        if (n < k) return false;

        int total = 1 << k;
        boolean[] seen = new boolean[total];

        int i = 0;
        int j = 0;
        int num = 0;
        int mask = total - 1;

        while (j < n) {
            num = ((num << 1) & mask) | (s.charAt(j) - '0');

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                seen[num] = true;
                i++;
                j++;
            }
        }

        for (boolean b : seen) {
            if (!b) return false;
        }

        return true;

    }
}