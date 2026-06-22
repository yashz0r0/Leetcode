// Last updated: 22/06/2026, 23:59:01
class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer,Integer> freq= new HashMap<>();

        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        List<Integer> val= new ArrayList<>(freq.keySet());
        Collections.sort(val);


        for(int i=0;i<val.size();i++){
            for(int j=i+1;j<val.size();j++){
                if(!freq.get(val.get(i)).equals(freq.get(val.get(j)))){
                    return new int[]{
                        val.get(i),val.get(j)
                    };
                }
            }
        }

        return new int[]{
            -1,-1
        };
    }
}