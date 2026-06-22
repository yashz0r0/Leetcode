// Last updated: 23/06/2026, 00:00:12
class Solution {
    public int countElements(int[] nums, int k) {
        int n= nums.length;
        if(k==0) return n;

        Arrays.sort(nums);

        int klar= nums[n-k];


        int count=0;
        for(int num:nums){
            if(num<klar) count++;
            
        }
        

       return count;
        
    }
}