// Last updated: 23/06/2026, 00:03:16
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n=candies.length;
        int mx=0;
        for(int i=0;i<n;i++){
            mx= Math.max(mx,candies[i]);
        }
        ArrayList<Boolean> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(candies[i]+extraCandies>=mx){
                list.add(true);
            }else{
                list.add(false);
            }
        }

        return list;
    }
}