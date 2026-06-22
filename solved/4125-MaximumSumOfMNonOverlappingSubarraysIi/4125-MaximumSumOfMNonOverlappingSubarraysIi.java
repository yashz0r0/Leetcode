// Last updated: 23/06/2026, 00:00:26
class Solution {

    static class Pair{
        long val;
        long cnt;
        Pair(long val, long cnt){
            this.val=val;
            this.cnt=cnt;
        }
    }

    static class Node{
        int idx;
        long val;
        int cnt;
        Node(int idx, long val, int cnt){
            this.idx=idx;
            this.val=val;
            this.cnt=cnt;
        }
    }
    long[] pref;
    int n, m, l, r;

    public Pair check(long pen){
        long[] dpval= new long[n+1];
        int[] dpcnt=new int[n+1];
        ArrayDeque<Node> dq= new ArrayDeque<>();

        for(int i=1;i<=n;i++){
            int j=i-l;
            if(j>=0){
                long val=dpval[j]-pref[j];
                int cnt=dpcnt[j];
                while(!dq.isEmpty()){
                    Node back=dq.peekLast();
                    if(val>back.val|| (val==back.val && cnt>=back.cnt)){
                        dq.pollLast();
                    }else{
                        break;
                    }
                }
                dq.addLast(new Node(j,val,cnt));
            }

            while(!dq.isEmpty()&& dq.peekFirst().idx<i-r){
                dq.pollFirst();
            }
            dpval[i]=dpval[i-1];
            dpcnt[i]=dpcnt[i-1];
            if(!dq.isEmpty()){
                Node best=dq.peekFirst();
                long candidateval=best.val+pref[i]-pen;
                int candidatecnt=best.cnt+1;

                if(candidateval>dpval[i]||(candidateval==dpval[i]&&candidatecnt>dpcnt[i])){
                    dpval[i]=candidateval;
                    dpcnt[i]=candidatecnt;
                }
            }
        }

        return new Pair(dpval[n],dpcnt[n]);
    }

    private long bestOne(){
        long best=Long.MIN_VALUE;
        ArrayDeque<Integer> dq= new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            int j=i-l;
            if((j>=0)){
                while(!dq.isEmpty()&& pref[dq.peekLast()]>=pref[j]){
                    dq.pollLast();
                }
                dq.addLast(j);
            }
            while(!dq.isEmpty()&& dq.peekFirst()<i-r)dq.pollFirst();
            if(!dq.isEmpty())best=Math.max(best,pref[i]-pref[dq.peekFirst()]);
        }

        return best;
    }
    public long maximumSum(int[] nums, int m, int l, int r) {
        this.n=nums.length;
        this.m=m;
        this.l=l;
        this.r=r;
        pref=new long[n+1];
        for(int i=0;i<n;i++){
            pref[i+1]=pref[i]+nums[i];
        }

        Pair first=check(0);
        if(first.cnt==0)return bestOne();

        if(first.cnt<=m)return first.val;

        long low=0;
        long high=1_000_000_000_000_000L;
        while(low<high){
            long mid=(low+high+1)>>>1;
            if(check(mid).cnt>=m){
                low=mid;
            }else{
                high=mid-1;
            }
        }

        Pair res=check(low);
        return res.val+low*(long)m;
    }
}