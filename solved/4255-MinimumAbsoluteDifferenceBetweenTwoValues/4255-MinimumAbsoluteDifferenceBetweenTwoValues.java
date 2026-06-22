// Last updated: 22/06/2026, 23:58:45
class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==1&&nums[j]==2)min=Math.min(min, Math.abs(i-j));
                if(nums[i]==2&&nums[j]==1)min=Math.min(min, Math.abs(i-j));
            }
        }


        return min==Integer.MAX_VALUE?-1:min;
        
    }
}