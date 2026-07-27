// Last updated: 27/07/2026, 16:18:03
1class Solution {
2    public List<List<Integer>> subsets(int[] nums) {
3        int n=nums.length;
4        List<List<Integer>> ans= new ArrayList<>();
5        
6        int subset=1<<n;
7
8        for(int i=0;i<subset;i++){
9            List<Integer> list= new ArrayList<>();
10            for(int j=0;j<n;j++){
11                if((i&(1<<j))!=0)list.add(nums[j]);
12            }
13            ans.add(list);
14        }
15
16        return ans;
17    }
18}