// Last updated: 08/11/2026, 13:18:33
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3
4        int i=0,max=0, j=0, n=s.length();
5        HashMap<Character, Integer> map= new HashMap<>();
6
7        while(j<n){
8
9            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
10            if(map.size()==j-i+1){
11                max= Math.max(max, j-i+1);
12                j++;
13            }else{
14                while(map.size()<j-i+1){
15                    char left= s.charAt(i);
16                    if(map.get(left)==1) map.remove(left);
17                    else map.put(left,map.get(left)-1);
18                    i++;
19                }
20                j++;
21            }
22            
23        }
24         return max;
25    }
26}