// Last updated: 12/07/2026, 16:55:20
1class Solution {
2    int mod=1_000_000_007;
3    public int minimumCost(int[] nums, int k) {
4        long cnt=0;
5        int n=nums.length;
6        long res=k;
7        for(int i=0;i<n;i++){
8            if(res<nums[i]){
9                long rem=(nums[i]-res+k-1L)/k;
10                cnt+=rem;
11                res+=rem*(long)k;
12            }
13                res-=nums[i];
14            
15        }
16        long n1=cnt%mod;
17        long n2=(cnt+1)%mod;
18        long ans = (n1*n2) % mod;
19        ans=ans*500000004L%mod;
20        return (int)(ans%mod);
21        
22    }
23}