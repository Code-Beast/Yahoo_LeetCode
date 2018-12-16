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
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }
    
    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        if ((root == p || root == q) && (left == true || right == true) || left == true && right == true) {
            res = root;
            return true; 
        }
        if (root == p || root == q || left == true || right == true) return true;
        return false;
    }
}

// Runtime: 7ms