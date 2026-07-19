// Last updated: 19/07/2026, 08:18:12
1class Solution {
2    public boolean[] transformStr(String s, String[] strs) {
3        int n=s.length();
4        int[] zeros=new int[n];
5        int cnt=0;
6        for(int i=0;i<n;i++){
7            if(s.charAt(i)=='0')cnt++;
8            zeros[i]=cnt;
9        }
10
11        int totalzeros=cnt;
12        boolean[] ans= new boolean[strs.length];
13
14        for(int i=0;i<strs.length;i++){
15            String t=strs[i];
16            int tz=0;
17            int tq=0;
18            for(int j=0;j<n;j++){
19                if(t.charAt(j)=='0'){
20                    tz++;
21                }else if(t.charAt(j)=='?')tq++;
22            }
23            if(tz>totalzeros||tz+tq<totalzeros){
24                ans[i]=false;
25                continue;
26            }
27
28            int needz=totalzeros-tz;
29            int currz=0;
30            boolean val=true;
31
32            for(int j=0;j<n;j++){
33                char c=t.charAt(j);
34                if(c=='0'){
35                    currz++;
36                }else if(c=='?'){
37                    if(needz>0){
38                        currz++;
39                        needz--;
40                    }
41                }
42
43                if(currz<zeros[j]){
44                    val=false;
45                    break;
46                }
47            }
48            ans[i]=val;
49        }
50        return ans;
51    }
52}