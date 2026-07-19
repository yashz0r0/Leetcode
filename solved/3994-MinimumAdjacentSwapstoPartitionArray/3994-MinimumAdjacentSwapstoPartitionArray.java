// Last updated: 19/07/2026, 08:00:30
1class Solution {
2    public int minAdjacentSwaps(int[] nums, int a, int b) {
3        int mod=1_000_000_007;
4        int n=nums.length;
5        for(int i=0;i<n;i++){
6            if(nums[i]<a){
7                nums[i]=0;
8            }else if(nums[i]>=a && nums[i]<=b){
9                nums[i]=1;
10            }else if(nums[i]>b){
11                nums[i]=2;
12            }
13        }
14        
15
16        for(int x:nums){
17            System.out.print(x+" ");
18        }  
19        long ans = 0;
20        long ones = 0;
21        long twos = 0;
22
23        for (int x : nums) {
24            if (x == 0) {
25                ans += ones + twos;
26            } else if (x == 1) {
27                ans += twos;
28                ones++;
29            } else {
30                twos++;
31            }
32
33
34        }
35
36
37            return (int)(ans%mod);
38    
39    }
40}