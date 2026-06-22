// Last updated: 22/06/2026, 23:58:18
class Solution {
    public String sortVowels(String s) {
        int n=s.length();

        Set<Character> vowel= new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');


        Map<Character,Integer> freq= new HashMap<>();
        Map<Character,Integer> fstpos=new HashMap<>();

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(vowel.contains(c)){
                freq.put(c,freq.getOrDefault(c,0)+1);
                fstpos.putIfAbsent(c,i);
            }
        }
        List<Character> vowList= new ArrayList<>();
        for(char c: s.toCharArray()){
            if(vowel.contains(c))vowList.add(c);
        }

        Collections.sort(vowList, (a,b)->{
            if(!freq.get(a).equals(freq.get(b))){
                return freq.get(b)-freq.get(a);
            }
            return fstpos.get(a)-fstpos.get(b);
        });

        StringBuilder res= new StringBuilder(s);
        int idx=0;
        for(int i=0;i<n;i++){
            if(vowel.contains(s.charAt(i))){
                res.setCharAt(i,vowList.get(idx++));
            }
        }

        return res.toString();
    }
}