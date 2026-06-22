// Last updated: 23/06/2026, 00:03:17
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] res= new int[n];

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i==j)continue;

                if(nums[i]>nums[j]) count++;
            }
            res[i]=count;
        }
        return res;
    }
}