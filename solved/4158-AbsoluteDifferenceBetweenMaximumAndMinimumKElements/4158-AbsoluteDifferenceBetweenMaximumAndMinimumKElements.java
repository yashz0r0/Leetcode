// Last updated: 22/06/2026, 23:59:59
class Solution {
    public int absDifference(int[] nums, int k) {
        int n= nums.length;
        if(n==1||n==0) return 0;
        Arrays.sort(nums);

        int minsum=0;
        int maxsum=0;

        for(int i=0;i<k;i++){
            minsum+=nums[i];
        }

        for(int j=n-k;j<n;j++){
            maxsum+=nums[j];
        }

        return Math.abs(maxsum- minsum);
    }
}