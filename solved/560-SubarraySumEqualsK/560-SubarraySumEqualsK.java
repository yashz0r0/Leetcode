// Last updated: 26/06/2026, 15:09:58
1class Solution {
2    public int subarraySum(int[] nums, int k) {
3       int n=nums.length;
4       int sum=0;
5       int ans=0;
6       HashMap<Integer,Integer> map= new HashMap<>();
7       map.put(0,1);
8       for(int i=0;i<n;i++){
9        sum+=nums[i];
10
11        if(map.containsKey(sum-k))
12        ans+=map.get(sum-k);
13        map.put(sum,map.getOrDefault(sum,0)+1);
14       }
15
16       return ans;
17    }
18}