// Last updated: 28/06/2026, 08:16:47
1class Solution {
2    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
3
4        Arrays.sort(occupiedIntervals,(a,b)->Integer.compare(a[0],b[0]));
5        List<List<Integer>> ans= new ArrayList<>();
6        long l=occupiedIntervals[0][0],r=occupiedIntervals[0][1];
7
8
9        for(int i=1;i<=occupiedIntervals.length;i++){
10            if(i<occupiedIntervals.length&& occupiedIntervals[i][0]<=r+1){
11                r=Math.max(r,occupiedIntervals[i][1]);
12            }else{
13                if(r<freeStart||l>freeEnd)
14                    ans.add(Arrays.asList((int) l,(int) r));
15                   
16
17                else{
18                if(l<freeStart)
19                        ans.add(Arrays.asList((int) l,freeStart-1));
20                if(r>freeEnd)
21                    ans.add(Arrays.asList(freeEnd+1,(int) r));
22                    
23                }
24
25                if(i<occupiedIntervals.length){
26                    l=occupiedIntervals[i][0];
27                    r=occupiedIntervals[i][1];
28                }
29            }
30        }
31
32        return ans;
33        
34    }
35}