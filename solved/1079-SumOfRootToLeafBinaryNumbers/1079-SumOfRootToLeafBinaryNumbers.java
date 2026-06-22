// Last updated: 23/06/2026, 00:03:44
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   public static int sumRootToLeaf(TreeNode root) {

    if (root == null) {
        return 0;
    }

    Stack<TreeNode> s = new Stack<>();
    s.push(root);

    int total = 0;

   while(!s.isEmpty()){
       TreeNode curr= s.pop();

       if(curr.left==null&&curr.right==null){
        total+=curr.val;
       }
       if(curr.right!=null){
        curr.right.val=curr.right.val+curr.val*2;
        s.push(curr.right);
       }
       if(curr.left!=null){
        curr.left.val=curr.left.val+curr.val*2;
        s.push(curr.left);
       }
       
    
   }

    return total;
}
}