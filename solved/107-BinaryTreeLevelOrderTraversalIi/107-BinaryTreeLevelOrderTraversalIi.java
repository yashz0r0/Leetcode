// Last updated: 22/06/2026, 23:54:29
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res= new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> list= new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode curr= q.remove();

            if(curr==null){
                res.add(list);
                if(q.isEmpty())break;
                list= new ArrayList<>();
                q.add(null);
            }else{
                list.add(curr.val);

                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
        }
        Collections.reverse(res);

        return res;
    }
}