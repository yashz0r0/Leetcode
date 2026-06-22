// Last updated: 23/06/2026, 00:00:52
class Solution {
    public int totalWaviness(int num1, int num2) {
        int total=0;

        for(int i= num1;i<=num2;i++){
            String s = String.valueOf(i);
            int n= s.length();
            if(n<3) continue;

            for(int j=1;j<n-1;j++){
                int prev= s.charAt(j-1)-'0';
                int curr= s.charAt(j)-'0';
                int next=s.charAt(j+1)-'0';

                if(curr >prev&& curr>next )total++;
                else if(curr<prev&&curr<next) total++;
            }
        }

        return total;
        
    }
}