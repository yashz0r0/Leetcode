// Last updated: 23/06/2026, 00:02:54
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n=nums.length;
        Stack<Integer> s= new Stack<>();

        for(int i=0;i<n;i++){
            while(!s.isEmpty()&&s.peek()>nums[i]&&s.size() - 1 + (n - i) >= k)s.pop();

            if(s.size()<k)s.push(nums[i]);
        }
         int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = s.pop();
        }

        return res;
    }
}