// Last updated: 02/07/2026, 23:09:49
1class Solution {
2    public int trap(int[] height) {
3        int n=height.length;
4        int left[]= new int[n];
5        int right[]= new int[n];
6
7        left[0]=height[0];
8        for(int i=1;i<n;i++){
9            left[i]=Math.max(height[i],left[i-1]);
10        }
11
12        right[n-1]=height[n-1];
13        for(int i=n-2;i>=0;i--){
14            right[i]=Math.max(right[i+1],height[i]);
15        }
16
17        int trap=0;
18
19        for(int i=0;i<n;i++){
20            int waterlevel=Math.min(left[i],right[i]);
21           trap+=waterlevel-height[i];
22        }
23
24        return trap;
25        
26    }
27}