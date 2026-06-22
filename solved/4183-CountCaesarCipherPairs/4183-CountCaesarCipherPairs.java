// Last updated: 22/06/2026, 23:59:28
class Solution {
    public long countPairs(String[] words) {

        Map<List<Integer> , Long> map= new HashMap<>();

        for(String word: words){
            List<Integer> key=strfy(word);
            map.put(key,map.getOrDefault(key,0L)+1);
        }

        long ans=0;

        for(long cnt:map.values()){
            ans+=cnt*(cnt-1)/2;
        }
        return ans;
    }

    public List<Integer> strfy(String s){
      List<Integer> diff= new ArrayList<>();
        for(int i=0;i<s.length()-1;i++){
            int d= (s.charAt(i)-'a')-(s.charAt(i+1)-'a');
            
           diff.add((d%26+26)%26);
        }

        return diff;
    }
}