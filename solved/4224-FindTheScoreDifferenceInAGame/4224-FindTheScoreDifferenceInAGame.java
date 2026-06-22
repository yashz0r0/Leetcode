// Last updated: 22/06/2026, 23:59:08
class Solution {
    public int scoreDifference(int[] nums) {

        int n = nums.length;

        int p1=0;
        int p2=0;
        int active=1;

        for(int i=0;i<n;i++){
          int score=nums[i];
          if(score%2!=0){
            active=(active==1)?2:1;
          }
           if((i+1)%6==0){
            active=(active==1)?2:1;
          }

          if(active==1){
            p1+=score;
          }else{
            p2+=score;
          }
        }
        return p1-p2;
    }
}