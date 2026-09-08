// Last updated: 08/09/2026, 21:05:27
1class Solution {
2    public int countCommas(int n) {
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
13        return (int)total;
14        
15    }
16}