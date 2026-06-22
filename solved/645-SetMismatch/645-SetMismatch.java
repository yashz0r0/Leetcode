// Last updated: 22/06/2026, 23:52:44
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> map= new HashMap<>();
        int x=0;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==2) x=nums[i];
        }
        


        for(int i=1;i<=n;i++){
            if(!map.containsKey(i)){
                return new int[]{x,i};
            }
        }


        return new int[]{-1,-1};
    }
}