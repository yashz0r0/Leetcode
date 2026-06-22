// Last updated: 22/06/2026, 23:54:19
class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        String s1 = sb.toString();

        int i = 0;
        int j = s1.length() - 1;

        while (i < j) {
            if (s1.charAt(i) != s1.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
