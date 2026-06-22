// Last updated: 22/06/2026, 23:52:47
class Solution {
    public double findMaxAverage(int[] nums, int k) {

    int i=0;
    int n=nums.length;
    int j=0;
    double sum=0;
    double max=Integer.MIN_VALUE;

    while(j<n){
        sum+=nums[j];
        if(j-i+1<k){
            j++;
        }else if(j-i+1==k){
            max= Math.max(max,sum/k);
            sum-=nums[i];
            i++;
            j++;
        }

    }

    return max;
        
    }
}