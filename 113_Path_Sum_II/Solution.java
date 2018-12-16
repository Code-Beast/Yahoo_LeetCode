/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        helper(root, sum, res, path);
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root.left == null && root.right == null && sum == root.val) {
            path.add(root.val);
            res.add(path);
            return;
        } else if (root.left == null && root.right == null) return;
        path.add(root.val);
        if (root.left != null)
            helper(root.left, sum - root.val, res, new ArrayList<>(path));
        if (root.right != null)
            helper(root.right, sum - root.val, res, new ArrayList<>(path));
    }
}

// Runtime: 4ms




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        helper(root, sum, res, path);
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(path));
        }
        
        helper(root.left, sum - root.val, res, path);
        helper(root.right, sum - root.val, res, path);
        
        path.remove(path.size() - 1);
    }
}

// Runtime: 1ms
