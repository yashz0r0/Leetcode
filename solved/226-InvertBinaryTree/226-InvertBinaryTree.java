// Last updated: 03/07/2026, 21:18:38
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
17    TreeNode node;
18    public TreeNode invertTree(TreeNode root) {
19       if (root == null) return null;
20
21       
22        TreeNode temp = root.left;
23        root.left = root.right;
24        root.right = temp;
25
26     
27        invertTree(root.left);
28        invertTree(root.right);
29
30        return root;
31    }
32     
33}