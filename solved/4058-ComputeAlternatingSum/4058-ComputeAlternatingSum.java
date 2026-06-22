// Last updated: 23/06/2026, 00:00:50
class Solution {
    public int alternatingSum(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int sum=0;

        for(int i=0;i<n;i++){
            if(i%2==0) sum+=nums[i];
            else sum-=nums[i];
        }
        return sum;
    }
}