// Last updated: 23/06/2026, 00:03:09
class Solution {
    public int maxVowels(String s, int k) {

        int i = 0, j = 0;
        int n = s.length();
        char[] ch = s.toCharArray();
        int count = 0, max = 0;

        while (j < n) {

            if (isVowel(ch[j])) count++;

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {

                max = Math.max(max, count);

                if (isVowel(ch[i])) count--;
                i++;
                j++;
            }
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
