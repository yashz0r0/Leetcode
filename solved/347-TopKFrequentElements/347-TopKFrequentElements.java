// Last updated: 09/08/2026, 19:09:39
1class Solution {
2    class Pair{
3        int node;
4        int freq;
5        public Pair(int node,int freq){
6            this.node=node;
7            this.freq=freq;
8        }
9    }
10    public int[] topKFrequent(int[] nums, int k) { 
11        int n=nums.length;
12        HashMap<Integer,Integer> map= new HashMap<>();
13        for(int i=0;i<n;i++)map.put(nums[i],map.getOrDefault(nums[i],0)+1);
14        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));
15
16        for(int key:map.keySet()){
17            pq.offer(new Pair(key,map.get(key)));
18        }
19
20        int res[]= new int[k];
21        for(int i=0;i<k;i++){
22            res[i]=pq.poll().node;
23        }
24        return res;
25    }
26}