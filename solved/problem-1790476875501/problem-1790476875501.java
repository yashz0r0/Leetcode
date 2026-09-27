// Last updated: 27/09/2026, 08:11:15
1class Solution {
2    public int maxEqualAdjacentPairs(int[] nums) {
3        int initPair=0;
4        int maxGain=0;
5        Map<Long,Integer> pair= new HashMap<>();
6        for(int i=0;i<nums.length-1;i++){
7            if(nums[i]==nums[i+1]){
8                initPair++;
9            }else{
10                long min=Math.min(nums[i],nums[i+1]);
11                long max=Math.max(nums[i],nums[i+1]);
12                long key=(min<<32)|max;
13
14                int cnt=pair.getOrDefault(key,0)+1;
15                pair.put(key,cnt);
16                if(cnt>maxGain)maxGain=cnt;
17            }
18        }
19
20        return initPair+maxGain;
21    }
22}