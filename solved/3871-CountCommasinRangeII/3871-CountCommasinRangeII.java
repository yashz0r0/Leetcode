// Last updated: 09/09/2026, 20:55:43
1class Solution {
2    public long countCommas(long n) {
3
4        long total=0;
5        long start=1000;
6
7        while(start<=n){
8            total+=(n-start+1);
9            start*=1000;
10        }
11        
12
13        return total;
14        
15    }
16}