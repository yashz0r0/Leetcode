// Last updated: 26/06/2026, 12:57:32
1class Solution {
2    public long countMajoritySubarrays(int[] nums, int target) {
3        int n=nums.length;
4        Map<Integer,Integer> map= new HashMap<>();
5        map.put(0,1);
6        int cumsum=0;
7        long res=0;
8        int validleft=0;
9
10
11        for(int i=0;i<n;i++){
12           if (nums[i] == target) {
13                validleft += map.getOrDefault(cumsum, 0);
14                cumsum++;
15            } else {
16                cumsum--;
17                validleft -= map.getOrDefault(cumsum, 0);
18            }
19
20            map.put(cumsum, map.getOrDefault(cumsum, 0) + 1);
21            res += validleft;
22        }
23
24        return res;
25
26
27    }
28}