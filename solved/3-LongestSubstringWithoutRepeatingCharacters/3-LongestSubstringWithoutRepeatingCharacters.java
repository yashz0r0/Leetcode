// Last updated: 22/06/2026, 23:55:16
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int i=0,max=0, j=0, n=s.length();
        HashMap<Character, Integer> map= new HashMap<>();

        while(j<n){

            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.size()==j-i+1){
                max= Math.max(max, j-i+1);
                j++;
            }else{
                while(map.size()<j-i+1){
                    char left= s.charAt(i);
                    if(map.get(left)==1) map.remove(left);
                    else map.put(left,map.get(left)-1);
                    i++;
                }
                j++;
            }
            
        }
         return max;
    }
}