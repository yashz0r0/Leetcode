// Last updated: 02/08/2026, 12:23:36
1class Solution {
2    public int[] countTasks(int[] tasks, int[] shifts) {
3        int n=tasks.length;
4        int m=shifts.length;
5        long[] pref= new long[n];
6        pref[0]=tasks[0];
7        for(int i=1;i<n;i++){
8            pref[i]=pref[i-1]+tasks[i];
9        }
10
11        long total=pref[n-1];
12        long completed=0;
13        int[] ans=new int[m];
14
15        for(int i=0;i<m;i++){
16            completed+=shifts[i];
17            if(completed>=total){
18                ans[i]=0;
19                completed=0;
20            }else{
21                int idx=upperBound(pref,completed);
22                ans[i]=n-idx;
23            }
24        }
25        return ans;
26    }
27    public int upperBound(long[] arr,long target){
28        int l=0,r=arr.length;
29        while(l<r){
30            int mid=(r+l)>>1;
31            if(arr[mid]<=target)l=mid+1;
32            else r=mid;
33        }
34        return l;
35    }
36}