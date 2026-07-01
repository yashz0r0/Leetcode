// Last updated: 01/07/2026, 23:45:49
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
20        solve(root,"");
21        return list;
22    }
23
24    public void solve(TreeNode root,String op){
25        if(root==null){
26            return;
27        }
28        if (op.length() == 0)
29            op = "" + root.val;
30        else
31            op = op + "->" + root.val;
32        if (root.left == null && root.right == null) {
33            list.add(op);
34            return;
35        }
36      
37        solve(root.left,op);
38        solve(root.right,op);
39      
40    }
41}