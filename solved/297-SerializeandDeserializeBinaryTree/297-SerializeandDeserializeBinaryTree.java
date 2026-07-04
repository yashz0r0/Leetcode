// Last updated: 05/07/2026, 00:05:56
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10public class Codec {
11
12    // Encodes a tree to a single string.
13    public TreeNode serialize(TreeNode root) {
14        return root;
15    }
16
17    // Decodes your encoded data to tree.
18    public TreeNode deserialize(TreeNode data) {
19        return data;
20    }
21}
22
23// Your Codec object will be instantiated and called as such:
24// Codec ser = new Codec();
25// Codec deser = new Codec();
26// TreeNode ans = deser.deserialize(ser.serialize(root));