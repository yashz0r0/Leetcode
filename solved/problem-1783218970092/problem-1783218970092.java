// Last updated: 05/07/2026, 08:06:10
1class Solution {
2    public int maxDigitRange(int[] nums) {
3        HashMap<Integer,Integer> map= new HashMap<>();
4        int max=0;
5
6        for(int num:nums){
7            int x=num,mn=9,mx=0;
8            while(x>0){
9                int d=x%10;
10                mn=Math.min(mn,d);
11                mx=Math.max(mx,d);
12                x/=10;
13            }
14            int range=mx-mn;
15            map.put(range,map.getOrDefault(range,0)+num);
16            max=Math.max(max,range);
17            
18        }
19
20        return map.get(max);
21    }
22}