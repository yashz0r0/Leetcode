// Last updated: 23/06/2026, 00:00:17
class Solution {
    public int prefixConnected(String[] words, int k) {
         Map<String, Integer> map = new HashMap<>();

        for (String w : words) {
            if (w.length() < k) continue;

            String pre = w.substring(0, k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        int groups = 0;

        for (int freq : map.values()) {
            if (freq >= 2) groups++;
        }

        return groups;
    }
}
