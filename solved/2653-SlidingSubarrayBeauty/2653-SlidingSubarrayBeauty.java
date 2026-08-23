// Last updated: 23/08/2026, 18:21:24
1class Solution {
2    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
3        int n= nums.length;
4        TreeMap<Integer, Integer> map= new TreeMap<>();
5        int[] res= new int[n-k+1];
6
7        int i=0;
8        int j=0;
9
10        while(j<n){
11            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
12
13            if(j-i+1<k){
14                j++;
15            }else if(j-i+1==k){
16                res[i]= findBeauty(map, x);
17                int out= nums[i];
18                if(map.get(out)==1) map.remove(out);
19                else{
20                    map.put(out, map.get(out)-1);
21                }
22                i++;
23                j++;
24            }
25        }
26        return res;
27    }
28    public int findBeauty(TreeMap<Integer,Integer> map,int x){
29        int cnt=0;
30        for(int key:map.keySet()){
31            if(key>=0)break;
32            cnt+= map.get(key);
33            if(cnt>=x)return key;
34        }
35
36        return 0;
37    }
38}