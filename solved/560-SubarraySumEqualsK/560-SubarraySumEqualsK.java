// Last updated: 26/06/2026, 15:20:19
1class Solution {
2    public int subarraySum(int[] nums, int k) {
3       int n=nums.length;
4       int sum=0;
5       int ans=0;
6       HashMap<Integer,Integer> map= new HashMap<>();
7       map.put(0,1);
8       for(int i=0;i<n;i++){
9        sum+=nums[i];
10        //  System.out.println("step "+(i+1)+": "+sum);
11        if(map.containsKey(sum-k)){
12          ans+=map.get(sum-k);
13        //   System.out.println("inside contains and sum-k "+ (sum-k));
14        //   System.out.println(ans);
15        //   System.out.println((sum-k)+" "+map.get(sum-k));
16        }
17        map.put(sum,map.getOrDefault(sum,0)+1);
18        //  System.out.println("Map");
19        //  for(int key:map.keySet()){
20        //      System.out.println(key+" "+map.get(key) );
21        //  }
22       }
23
24       return ans;
25    }
26}