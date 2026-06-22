// Last updated: 22/06/2026, 23:55:57
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }

    
        return letters[0];
    }
}
