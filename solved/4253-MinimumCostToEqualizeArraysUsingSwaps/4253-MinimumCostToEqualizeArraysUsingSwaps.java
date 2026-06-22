// Last updated: 22/06/2026, 23:58:47
class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        int n=nums1.length;
        Map<Integer,Integer> total= new HashMap<>();
        for(int x:nums1)total.put(x,total.getOrDefault(x,0)+1);
        for(int x:nums2)total.put(x,total.getOrDefault(x,0)+1);
        for(int val:total.values())if(val%2!=0) return -1;
        Map<Integer,Integer> map= new HashMap<>();
        for(int x:nums1)map.put(x,map.getOrDefault(x,0)+1);
        int swap=0;
        for(int x:total.keySet()){
            int need= total.get(x)/2;
            int have= map.getOrDefault(x,0);
            swap+=Math.abs(have-need);        
        }
        return swap/2;
    }
}