// Last updated: 26/07/2026, 08:19:34
1class Solution {
2    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
3        int[] t1=new int[series1.length];
4        Set<Integer> set= new HashSet<>();
5        for(int i=0;i<series1.length;i++)t1[i]=series1[i][0];
6
7        int[] t2=new int[series2.length];
8        for(int i=0;i<series2.length;i++)t2[i]=series2[i][0];
9        for(int t:t1)set.add(t);
10        for(int t:t2)set.add(t);
11        List<Integer> times=new ArrayList<>(set);
12        Collections.sort(times);
13        List<List<Integer>> res=new ArrayList<>();
14        for(int i=0;i<times.size();i++){
15            int t=times.get(i);
16            int idx1=Arrays.binarySearch(t1,t);
17            if(idx1<0)idx1=-idx1-1;
18            int val1=idx1<series1.length?series1[idx1][1]:0;
19            int idx2=Arrays.binarySearch(t2,t);
20            if(idx2<0)idx2=-idx2-1;
21            int val2=idx2<series2.length?series2[idx2][1]:0;
22            res.add(Arrays.asList(t, val1 + val2));
23        }
24
25        
26        return res;
27    }
28}