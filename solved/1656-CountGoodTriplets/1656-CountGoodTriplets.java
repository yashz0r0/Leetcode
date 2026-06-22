// Last updated: 23/06/2026, 00:03:02
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n= arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int s1= Math.abs(arr[i]-arr[j]);
                    int s2= Math.abs(arr[j]-arr[k]);
                    int s3= Math.abs(arr[i]-arr[k]);
                    
                    if(s1<=a&&s2<=b&&s3<=c)cnt++;
                }
            }
        }

        return cnt;
        
    }
}