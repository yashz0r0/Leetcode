// Last updated: 22/06/2026, 23:55:08
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
         List<List<Integer>> res= new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(i>0 &&nums[i]==nums[i-1])continue;

            int l=i+1;
            int r=n-1;

            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];

                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l]==nums[l+1] )l++;
                     while(l<r && nums[r]==nums[r-1] )r--;
                     l++;
                     r--;

                }else if(sum<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
       return res;
    }
}
