// Last updated: 22/06/2026, 23:58:02
class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n=nums.length;
        List<Integer> res=new ArrayList<>();
        if(n==1){
            res.add(nums[0]);
            return res;
            
        }
        int[] left= new int[n];
        int[] right= new int[n];

        left[0]=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],nums[i-1]);
        }
        right[n-1]=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],nums[i+1]);
        }

        for(int i=0;i<n;i++){
            if(i==0|| i==n-1|| nums[i]>left[i]||nums[i]>right[i]) res.add(nums[i]);
        }


        return res;
    }
}