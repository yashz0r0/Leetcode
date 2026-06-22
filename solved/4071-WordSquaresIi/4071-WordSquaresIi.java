// Last updated: 23/06/2026, 00:00:44
class Solution {
    public List<List<String>> wordSquares(String[] words) {

        int n=words.length;
        List<List<String>> list= new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i)continue;
                for(int k=0;k<n;k++){
                    if(k==i||k==j)continue;
                    for(int l=0;l<n;l++){
                        if(l==i||l==j||l==k)continue;

                        String top=words[i];
                        String left=words[j];
                        String right=words[k];
                        String bottom=words[l];

                        if(top.charAt(0)==left.charAt(0)&&
                          top.charAt(3)==right.charAt(0)&&
                          bottom.charAt(0)==left.charAt(3)&&
                          bottom.charAt(3)==right.charAt(3)){
                            list.add(Arrays.asList(top,left,right, bottom));
                          }
                    }
                }
            }
        }

        list.sort((a,b)->{
            for(int i=0;i<4;i++){
                int cmp=a.get(i).compareTo(b.get(i));
                if(cmp!=0) return cmp;
            }
            return 0;
        });
        return list;
    }
}