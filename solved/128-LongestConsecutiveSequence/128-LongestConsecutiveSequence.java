// Last updated: 23/09/2026, 19:43:47
1class Solution {
2    public int longestConsecutive(int[] nums) {
3        Set<Integer> set= new HashSet<>();
4
5        for(var num:nums){
6            set.add(num);
7        }
8
9        int ans=0;
10        for(var n:set){
11
12            if(!set.contains(n-1)){
13                int len=1;
14                while(set.contains(n+len)) len++;
15                ans=Math.max(len,ans);
16            }
17            
18        }
19
20        return ans;
21    }
22}