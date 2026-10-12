// Last updated: 12/10/2026, 20:24:39
1class Solution {
2    public List<Integer> maxPrimes(int n, int s) {
3        boolean[] isPrime= new boolean[n+1];
4        for(int i=2;i<=n;i++){
5            isPrime[i]=true;
6        }
7
8        for(int p=2;p*p<=n;p++){
9            if(isPrime[p]){
10                for(int i=p*p;i<=n;i+=p){
11                    isPrime[i]=false;
12                }
13            }
14        }
15
16        List<Integer> prime= new ArrayList<>();
17        long currsum=0;
18
19        for(int p=2;p<=n;p++){
20            if(isPrime[p]){
21                if(currsum+p<=s){
22                    prime.add(p);
23                    currsum+=p;
24                }else{
25                    break;
26                }
27            }
28        }
29
30        return prime;
31    }
32}