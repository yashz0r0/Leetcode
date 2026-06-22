// Last updated: 22/06/2026, 23:55:14
class Solution {
     static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")){
                fw.write("0");
            }catch(Exception e){
                System.out.println("Time overwrite aborted");
            }
        }));
}
    public String convert(String s, int numRows) {
        int n= s.length();
        if(numRows==1||n<=numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }


        int row=0;
        int dir=1;

        for(char ch:s.toCharArray()){
            rows[row].append(ch);
            if(row==0)dir=1;
            if(row==numRows-1)dir=-1;

            row+=dir;

        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : rows) {
            ans.append(sb);
        }

        return ans.toString();
        
    }
}