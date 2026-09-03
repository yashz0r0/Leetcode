// Last updated: 03/09/2026, 19:36:46
1class Solution {
2    public void nextPermutation(int[] nums) {
3        int n=nums.length;
4        int idx=-1;
5
6        for(int i=n-2;i>=0;i--){
7            if(nums[i+1]>nums[i]){
8                idx=i;
9                break;
10            }
11        } 
12
13
14        if(idx==-1){// reverse
15        reverse(nums,0,n-1);
16        return;
17        }
18
19        for(int i=n-1;i>idx;i--){
20            if(nums[i]>nums[idx]){
21                int temp=nums[i];
22                nums[i]=nums[idx];
23                nums[idx]=temp;
24                break;
25            }
26        }
27
28        reverse(nums,idx+1,n-1);
29    }
30
31
32      public void reverse(int[] nums, int i, int j){
33        while(i<j){
34            int temp=nums[i];
35            nums[i]=nums[j];
36            nums[j]=temp;
37            i++;
38            j--;
39        }
40    }
41}