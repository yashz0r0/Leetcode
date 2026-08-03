// Last updated: 03/08/2026, 21:12:26
1class Solution {
2    class Pair{
3        char ch;
4        int freq;
5
6        public Pair(char ch,int freq ){
7            this.ch=ch;
8            this.freq=freq;
9        }
10    }
11    public String reorganizeString(String s) {
12        HashMap<Character,Integer> map= new HashMap<>();
13
14        for(char ch:s.toCharArray()){
15            map.put(ch,map.getOrDefault(ch,0)+1);
16        }
17        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->b.freq-a.freq);
18
19        for(char ch:map.keySet()){
20            pq.offer(new Pair(ch,map.get(ch)));
21        }
22
23        StringBuilder sb = new StringBuilder();
24        Pair prev = null;
25
26        while(!pq.isEmpty()){
27            Pair curr= pq.poll();
28
29            sb.append(curr.ch);
30            curr.freq--;
31
32            if(prev!=null&&prev.freq>0){
33                pq.offer(prev);
34            }
35            prev=curr;
36        }
37
38
39        if(sb.length()!=s.length())return "";
40
41        return sb.toString();
42        
43    }
44}