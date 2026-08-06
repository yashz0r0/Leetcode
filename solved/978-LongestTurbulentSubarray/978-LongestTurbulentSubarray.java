// Last updated: 06/08/2026, 22:58:44
1class Solution {
2    public int maxTurbulenceSize(int[] arr) {
3        
4        int max = 1, small = 1, big = 1;
5        int i = 1, n = arr.length;
6        
7        while(i < n){
8
9            if(arr[i] > arr[i - 1]){
10                big++;
11                small = big;
12                big = 1;
13            }
14            else if(arr[i] < arr[i - 1]){
15                small++;
16                big = small;
17                small = 1;
18            }
19            else{
20                small = 1;
21                big = 1;
22            }
23            max = Math.max(max,Math.max(small,big));
24            
25            i++;
26        }
27
28        return max;
29    }
30}