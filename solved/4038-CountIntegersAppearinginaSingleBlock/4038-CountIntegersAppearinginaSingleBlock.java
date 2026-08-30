// Last updated: 30/08/2026, 19:40:41
1class Solution {
2    public int countSpecialIntegers(int[] nums) {
3        if(nums.length==1)return 1;
4        HashSet<Integer> set= new HashSet<>();
5
6        set.add(nums[0]);
7
8        for(int i=1;i<nums.length;i++){
9            if(nums[i]!=nums[i-1]){
10
11              if(set.contains(nums[i])){
12                set.remove(nums[i]);
13                  set.add(-nums[i]);  
14                }else if(!set.contains(-nums[i])){
15                  set.add(nums[i]);
16                }
17            }
18        }
19            int cnt=0;
20
21
22        for(int x:set){
23            if(x>0)cnt++;
24        }
25
26        return cnt;
27        
28    }
29}