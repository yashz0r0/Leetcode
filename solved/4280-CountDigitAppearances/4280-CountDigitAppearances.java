// Last updated: 22/06/2026, 23:58:20
class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int cnt=0;
        for(int num:nums){
            String s=String.valueOf(num);

            for(char c:s.toCharArray()){
                if(c==(char)(digit+'0'))cnt++;
            }
        }

        return cnt;
    }
}