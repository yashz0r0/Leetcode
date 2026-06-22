// Last updated: 22/06/2026, 23:59:44
class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n=nums.length;
        List<Integer> nonNeg= new ArrayList<>();

        for(int x:nums){
            if(x>=0)nonNeg.add(x);
        }

        int m= nonNeg.size();
            if(m==0) return nums;

        k=k%m;

        List<Integer> rotate= new ArrayList<>();

        for(int i=0;i<m;i++){
            rotate.add(nonNeg.get((i+k)%m));
        }
        int j=0;

        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                nums[i]= rotate.get(j++);
            }
        }

        return nums;
    }
}