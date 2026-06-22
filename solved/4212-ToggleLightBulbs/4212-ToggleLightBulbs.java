// Last updated: 22/06/2026, 23:59:15
class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {

        Set<Integer> set = new TreeSet<>();

        for (int el : bulbs) {
            if (set.contains(el)) {
                set.remove(el);  
            } else {
                set.add(el);      
            }
        }

        List<Integer> result = new ArrayList<>(set);
        
        return result;
    }
}
