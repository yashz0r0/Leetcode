// Last updated: 23/06/2026, 00:02:04
class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char a = pattern.charAt(0);
        char b = pattern.charAt(1);

        long countA = 0;
        long countB = 0;
        long subseq = 0;

       
        for (char c : text.toCharArray()) {
            if (c == b) {
                subseq += countA;
                countB++;
            }
            if (c == a) {
                countA++;
            }
        }

        return subseq + Math.max(countA, countB);
    }
}