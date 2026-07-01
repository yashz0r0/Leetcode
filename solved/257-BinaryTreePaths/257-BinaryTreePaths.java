// Last updated: 01/07/2026, 23:47:29
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
17    List<String> list= new ArrayList<>();
18    public List<String> binaryTreePaths(TreeNode root) {
19         if (root == null) return list;
20        solve(root,root.val+"");
21        return list;
22    }
23
24    public void solve(TreeNode root,String op){
25        if(root==null){
26            return;
27        }
28        
29        if (root.left == null && root.right == null) {
30            list.add(op);
31            return;
32        }
33      
34        if (root.left != null)solve(root.left,op+"->"+root.left.val);
35        if (root.right != null)solve(root.right,op+"->"+root.right.val);
36      
37    }
38}