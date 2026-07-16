// Last updated: 16/07/2026, 22:25:20
1class Solution {
2    public long gcdSum(int[] nums) {
3
4        int n=nums.length;
5
6        int[] pref= new int[n];
7
8        int max=0;
9
10
11        for(int i=0;i<n;i++){
12            max= Math.max(max, nums[i]);
13            pref[i]=gcd(nums[i],max);
14        }
15        Arrays.sort(pref);
16
17        int i=0;
18        int j=n-1;
19        long sum=0;
20
21        while(i<j){
22            sum+=gcd(pref[i],pref[j]);
23            i++;
24            j--;
25        }
26        return sum;
27    }
28
29
30    private int gcd(int a, int b){
31        while(b!=0){
32            int t=b;
33            b=a%b;
34            a=t;
35        }
36        return a;
37    }
38}