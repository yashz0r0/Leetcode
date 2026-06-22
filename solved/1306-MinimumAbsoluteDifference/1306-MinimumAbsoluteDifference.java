// Last updated: 23/06/2026, 00:03:32
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        int n= arr.length;
        List<List<Integer>> res= new ArrayList<>();

        Arrays.sort(arr);
        int min= Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            min= Math.min(min,Math.abs(arr[i]-arr[i-1]));
        }
        List<Integer> list;

        for(int i=1;i<n;i++){
            if(min==Math.abs(arr[i]-arr[i-1])){
                list= new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                res.add(list);
            }
        }
        return res;
    }
}