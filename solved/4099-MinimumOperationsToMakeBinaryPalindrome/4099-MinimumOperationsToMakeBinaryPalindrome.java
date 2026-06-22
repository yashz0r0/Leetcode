// Last updated: 23/06/2026, 00:00:35
class Solution {
    public int[] minOperations(int[] nums) {
        List<Integer> list= new ArrayList<>();
        for(int i=1;i<=10000;i++){
            if(Palin(i)) list.add(i);
        }

        int ans[] = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int x= nums[i];

            int idx= Collections.binarySearch(list,x);
            if(idx>=0){
                ans[i]=0;
            }else{
                int in= -idx-1;
                int best= Integer.MAX_VALUE;
                if(in<list.size())
                    best=Math.min(best, Math.abs(list.get(in)-x));
                if(in>=-1)
                     best=Math.min(best, Math.abs(list.get(in-1)-x));

                ans[i]= best;
            }
        }
        return ans;
    }

    public boolean Palin(int x){
        String s= Integer.toBinaryString(x);
        int l=0, r= s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}