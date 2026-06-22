// Last updated: 23/06/2026, 00:01:12
class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        long inf= Long.MAX_VALUE;
        long[] arr= new long[n];

        for(int i=0;i<n;i++){
            arr[i]=inf;
        }
        arr[0]=0;

        for(int[] r:restrictions){
            int idx=r[0];
            int val=r[1];
            arr[idx]=Math.min(arr[idx],val);
        }

        for(int i=1;i<n;i++){
            arr[i]=Math.min(arr[i],arr[i-1]+diff[i-1]);
        }

        for(int i=n-2;i>=0;i--){
            arr[i]=Math.min(arr[i],arr[i+1]+diff[i]);
        }
        long ans=0;
        for(long a:arr){
            ans=Math.max(ans,a);
        }

        return (int)ans;
    }
}