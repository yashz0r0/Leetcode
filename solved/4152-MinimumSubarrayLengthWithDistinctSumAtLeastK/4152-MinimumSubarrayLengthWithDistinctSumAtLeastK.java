// Last updated: 23/06/2026, 00:00:04
class Solution {
    public int minLength(int[] nums, int k) {

        int i=0;
        int j=0;
        int n=nums.length;
        int sum=0;
        int cnt=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map= new HashMap<>();

        while(j<n){
            int val=nums[j];
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            if(map.get(val)==1){
                sum+=val;
            }

            while(sum>=k){
                cnt=Math.min(cnt,j-i+1);
                int left= nums[i];
                map.put(left,map.get(left)-1);
                if(map.get(left)==0) {
                    map.remove(left);
                    sum-=left;
                    }
                i++;
            }
            
            j++;
        }
        return cnt==Integer.MAX_VALUE?-1:cnt;
    }
}