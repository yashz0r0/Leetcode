// Last updated: 22/06/2026, 23:57:46
class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];

        ans[0] = ".".repeat(n);
        char[] row = new char[n];
        Arrays.fill(row, '#');
        row[n - 1] = '.';

        String s = new String(row);

        for (int i = 1; i < m; i++) {
            ans[i] = s;
        }

        return ans;
    }
}