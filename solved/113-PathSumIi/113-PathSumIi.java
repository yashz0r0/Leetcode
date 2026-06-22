// Last updated: 22/06/2026, 23:54:23
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(TreeNode node, int target, 
                     List<Integer> path, 
                     List<List<Integer>> ans) {
        
        if (node == null) return;

        path.add(node.val);


        if (node.left == null && node.right == null) {
            if (target == node.val) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            dfs(node.left, target - node.val, path, ans);
            dfs(node.right, target - node.val, path, ans);
        }

        path.remove(path.size() - 1);
    }
}