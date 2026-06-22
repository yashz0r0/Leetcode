// Last updated: 22/06/2026, 23:53:32
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word = s.trim().split("\\s+");

        if (pattern.length() != word.length) return false;

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverse = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            

            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(word[i])) return false;
            } else {
                map.put(ch, word[i]);
            }

            if (reverse.containsKey(word[i])) {
                if (reverse.get(word[i]) != ch) return false;
            } else {
                reverse.put(word[i], ch);
            }
        }

        return true;
    }
}