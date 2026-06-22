// Last updated: 22/06/2026, 23:53:17
class Solution {
    public boolean canConstruct(String s, String t) {

        Map<Character, Integer> mp1= new HashMap<>();
        Map<Character, Integer> mp2= new HashMap<>();

        for(int i=0;i<s.length();i++){
            mp1.put(s.charAt(i),mp1.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<t.length();i++){
            mp2.put(t.charAt(i),mp2.getOrDefault(t.charAt(i),0)+1);
        }


        for(char x: mp1.keySet()){

            if (mp1.get(x) > mp2.getOrDefault(x, 0)) {
                return false;
            }
        }

        return true;
        
    }

}