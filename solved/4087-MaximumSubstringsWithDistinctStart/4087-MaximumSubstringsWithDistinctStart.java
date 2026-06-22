// Last updated: 23/06/2026, 00:00:39
class Solution {
    public int maxDistinct(String s) {

        Set<Character> set= new HashSet<>();

        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }

        return set.size();
    }
}