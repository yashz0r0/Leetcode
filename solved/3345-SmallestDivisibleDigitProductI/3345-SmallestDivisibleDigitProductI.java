// Last updated: 06/08/2026, 13:25:32
1class Solution {
2    public int smallestNumber(int n, int t) {
3        while(true){
4            int x=n;
5            int mul=1;
6            while(x>0){
7                mul*=x%10;
8                x/=10;
9            }
10            if(mul%t==0)return n;
11            n++;
12        }
13
14    }
15}