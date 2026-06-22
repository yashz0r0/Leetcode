// Last updated: 23/06/2026, 00:04:00
class Solution {
    List<String> list= new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
         solve(s,"");

         return list;
    }

    public void solve(String ip, String op){
        if(ip.length()==0){
            list.add(op);
            return;
        }

        char ch=ip.charAt(0);

        if(Character.isLetter(ch)){
            solve(ip.substring(1),op+Character.toLowerCase(ch));
            solve(ip.substring(1),op+Character.toUpperCase(ch));
        }else{
            solve(ip.substring(1),op+ch);
        }

    }
}