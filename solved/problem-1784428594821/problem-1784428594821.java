// Last updated: 19/07/2026, 08:06:34
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    int ans=0;
18    public int countDominantNodes(TreeNode root) {
19        dfs(root);
20        return ans;
21        
22    }
23
24    public int dfs(TreeNode node){
25        if(node==null)return Integer.MIN_VALUE;
26        int left=dfs(node.left);
27        int right=dfs(node.right);
28        int max=Math.max(node.val,Math.max(left,right));
29        if(node.val==max)ans++;
30
31        return max;
32        
33    }
34}