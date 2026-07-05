// Last updated: 05/07/2026, 09:01:04
1class Solution {
2    public long getSum(int[] nums) {
3        int n=nums.length;
4        long[] pref=new long[n+1];
5        for(int i=0;i<n;i++){
6            pref[i+1]=pref[i]+nums[i];
7        }
8        int[] newInput=new int[2*n+1];
9        int idx=0;
10        for(int i=0;i<newInput.length;i++){
11            if(i%2!=0){
12                newInput[i]=nums[idx++];
13            }else{
14                newInput[i]=-1;
15            }
16        }
17
18        int[] T= new int[newInput.length];
19        int st=0;
20        int end=0;
21
22        for(int i=0;i<newInput.length;){
23            while(st>0&&end<newInput.length-1 && newInput[st-1]==newInput[end+1]){
24                st--;
25                end++;
26            }
27            T[i]=end-st+1;
28
29            if(end==T.length-1)break;
30            int newCenter= end +(i%2==0?1:0);
31
32            for(int j=i+1;j<=end;j++){
33                T[j]=Math.min(T[i-(j-i)],2*(end-j)+1);
34                if(j+T[i-(j-i)]/2==end){
35                    newCenter=j;
36                    break;
37                }
38            }
39            i=newCenter;
40            end=i+T[i]/2;
41            st=i-T[i]/2;
42        }
43        long max=0;
44
45        for(int i=0;i<T.length;i++){
46            int val=T[i]/2;
47            if(val>0){
48                int ost=(i-val)/2;
49                int oend=ost+val-1;
50                long currsum=pref[oend+1]-pref[ost];
51                if(currsum>max){
52                    max=currsum;
53                }
54            }
55        }
56        return max;
57        
58    }
59}