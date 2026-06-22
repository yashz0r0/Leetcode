// Last updated: 22/06/2026, 23:59:09
import java.util.*;

class Solution {
    public int minOperations(String s) {
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);

        if (s.equals(new String(sorted))) return 0;

        int n = s.length();

        if (n == 2 && s.charAt(0) > s.charAt(1)) return -1;

        if (s.charAt(0) == sorted[0] || s.charAt(n - 1) == sorted[n - 1])
            return 1;

        char mn = sorted[0];
        char mx = sorted[n - 1];

        boolean mnPrefix = false, mxSuffix = false;

        for (int i = 0; i < n - 1; i++)
            if (s.charAt(i) == mn) mnPrefix = true;

        for (int i = 1; i < n; i++)
            if (s.charAt(i) == mx) mxSuffix = true;

        if (!mnPrefix && !mxSuffix) return 3;

        return 2;
    }
}