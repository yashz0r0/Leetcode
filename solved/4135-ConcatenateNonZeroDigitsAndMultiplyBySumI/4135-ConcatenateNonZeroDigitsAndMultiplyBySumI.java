// Last updated: 23/06/2026, 00:00:21
class Solution {
    public long sumAndMultiply(int n) {
        String s= String.valueOf(n);
        StringBuilder sb= new StringBuilder();
      long sum=0;

        for(int i=0;i< s.length();i++){
            if(s.charAt(i)!='0'){
                sb.append(s.charAt(i));
                sum+=s.charAt(i)-'0';
            }
        }
        if(sb.length() ==0) return 0;
        String st= sb.toString();

        return Long.parseLong(st)*sum;
        
    }
}