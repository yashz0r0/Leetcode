// Last updated: 05/07/2026, 08:34:35
1class Solution {
2    public int divisibleGame(int[] nums) {
3        TreeSet<Integer> primes=new TreeSet<>();
4        primes.add(2);
5
6        for(int num:nums){
7            int x=num;
8            for(int i=2;i*i<=x;i++){
9                if(x%i==0){
10                    primes.add(i);
11                    while(x%i==0)x/=i;
12                }
13            }
14            if(x>1){
15                primes.add(x);
16            }
17        }
18        long maxdiff=-1;
19        int bk=2;
20        for(int k:primes){
21            long currmax=(nums[0]%k==0)?nums[0]:-nums[0];
22            long gmax=currmax;
23
24            for(int i=1;i<nums.length;i++){
25                long val=(nums[i]%k==0)?nums[i]:-nums[i];
26                currmax=Math.max(val,currmax+val);
27                gmax=Math.max(gmax,currmax);
28            }
29            if(gmax>maxdiff){
30                maxdiff=gmax;
31                bk=k;            
32            }else if(gmax==maxdiff)bk=Math.min(bk,k);
33        }
34        
35        int mod=1_000_000_007;
36        long product=maxdiff*bk;
37        long res=product%mod;
38        if(res<0){
39            res+=mod;
40        }
41        return (int)res;
42    }
43}