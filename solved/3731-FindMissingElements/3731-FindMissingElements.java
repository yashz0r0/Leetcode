// Last updated: 04/08/2026, 15:12:59
1class Solution {
2    public List<Integer> findMissingElements(int[] nums) {
3        int n= nums.length;
4        Arrays.sort(nums);
5        Set<Integer> set= new HashSet<>();
6        
7        for(int i=0;i<n;i++){
8            set.add(nums[i]);
9        }
10
11        List<Integer> list= new ArrayList<>();
12
13        for(int i=nums[0];i<nums[n-1];i++){
14            if(!set.contains(i)){
15                list.add(i);
16            }
17        }
18        return list;
19        
20    }
21}