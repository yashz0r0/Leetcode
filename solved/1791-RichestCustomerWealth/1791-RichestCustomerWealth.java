// Last updated: 23/06/2026, 00:02:56
class Solution {
    public int maximumWealth(int[][] nums) {

        int max=0;

        for(int i=0;i<nums.length;i++){
            int ans=0;
            for(int j=0;j<nums[0].length;j++){
                ans+=nums[i][j];
            }

            max=Math.max(max, ans);
        }
        return max;
    }
}