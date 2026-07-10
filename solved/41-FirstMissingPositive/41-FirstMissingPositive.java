// Last updated: 11/07/2026, 01:04:59
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int i=0;
4        while(i<nums.length){
5            int correct=nums[i]-1;
6            if(nums[i]<=0){
7                i++;
8            }
9            
10            else if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[correct]){
11                int temp=nums[i];
12                nums[i]=nums[correct];
13                nums[correct]=temp;           
14            }
15            else{
16                i++;
17            }
18
19        }
20        for(int j=0;j<nums.length;j++){
21            if(nums[j]!=j+1){
22                return j+1;
23            }
24        }
25
26        return nums.length+1;
27    }
28}