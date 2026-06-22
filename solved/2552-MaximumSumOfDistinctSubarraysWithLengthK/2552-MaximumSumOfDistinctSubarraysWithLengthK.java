// Last updated: 23/06/2026, 00:01:49
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
     HashMap<Integer,Integer> map= new HashMap<>();
     int i=0;
     int j=0;
     int n=nums.length;
     long sum=0;
     long ans=0;

     while(j<n){
        sum+=nums[j];
        map.put(nums[j],map.getOrDefault(nums[j],0)+1);

        if(j-i+1<k){
            j++;
        }else if(j-i+1==k) {
            if(map.size()==k){
                ans=Math.max(sum,ans);
            }
            sum-=nums[i];
            
                map.put(nums[i],map.get(nums[i])-1);

                if(map.get(nums[i])==0)map.remove(nums[i]);
            
            i++;
            j++;
            
        }
     }

     return ans;
    }
}