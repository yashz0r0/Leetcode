// Last updated: 23/06/2026, 00:00:15
class Solution {
    public long minCost(String s, int[] cost) {
        long total=0;
        Map<Character, Long> map= new HashMap<>();

        for(int i=0;i<s.length();i++){
            total+=cost[i];
            char ch= s.charAt(i);

            map.put(ch, map.getOrDefault(ch,0L)+cost[i]);
        }
        long min= Long.MAX_VALUE;
        for(long keepcost:map.values()){
            min= Math.min(min, total-keepcost);
        }

        return min;
    }
}