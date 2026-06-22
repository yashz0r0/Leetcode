// Last updated: 22/06/2026, 23:54:41
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int[] merge= new int[nums1.length];
        int i=0;
        int j=0;
        int k=0;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                merge[k++]=nums1[i++];
            }else{
                merge[k++]=nums2[j++];
            }
        }

        while(i<m){
             merge[k++]=nums1[i++];
        }

        while(j<n){
             merge[k++]=nums2[j++];
        }


        for(int l=0;l<merge.length;l++){
            nums1[l]=merge[l];
        }

           
    }
}