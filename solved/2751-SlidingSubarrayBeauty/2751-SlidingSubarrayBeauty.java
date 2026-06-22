// Last updated: 23/06/2026, 00:01:42
class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n= nums.length;
        TreeMap<Integer, Integer> map= new TreeMap<>();
        int[] res= new int[n-k+1];

        int i=0;
        int j=0;

        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                res[i]= findBeauty(map, x);
                int out= nums[i];
                if(map.get(out)==1) map.remove(out);
                else{
                    map.put(out, map.get(out)-1);
                }
                i++;
                j++;
            }
        }
        return res;
    }
    public int findBeauty(TreeMap<Integer,Integer> map,int x){
        int cnt=0;
        for(int key:map.keySet()){
            if(key>=0)break;
            cnt+= map.get(key);
            if(cnt>=x)return key;
        }

        return 0;
    }
}