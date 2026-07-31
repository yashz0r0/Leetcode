// Last updated: 31/07/2026, 22:27:45
1class Solution {
2    public int minimumPushes(String word) {
3        int n = word.length();
4        Map<Character,Integer> map= new TreeMap<>();
5
6        for(char ch:word.toCharArray()){
7            map.put(ch,map.getOrDefault(ch,0)+1);
8        }
9
10        int i=0;
11        int cnt=0;
12        List<Integer> list= new ArrayList<>(map.values());
13        list.sort(Collections.reverseOrder());
14
15        for(int fr:list){
16            cnt+=(i/8+1)*fr;
17            i++;
18        }
19        return cnt;
20    }
21}