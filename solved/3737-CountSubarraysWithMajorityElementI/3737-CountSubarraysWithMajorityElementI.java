// Last updated: 25/06/2026, 22:01:45
1class Solution {
2    public int countMajoritySubarrays(int[] nums, int target) {
3        int n=nums.length;
4        int ans=0;
5
6
7        for(int l=0;l<n;l++){
8            int tarcount=0;
9
10            for(int r=l;r<n;r++){
11                if(nums[r]==target)tarcount++;
12
13                int len=r-l+1;
14                if(tarcount>len/2)ans++;
15            }
16        }
17
18        return ans;
19    }
20}