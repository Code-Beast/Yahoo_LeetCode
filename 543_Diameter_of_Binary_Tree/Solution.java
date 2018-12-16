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
    private int diameter;
        
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }
    
    private int longestPath(TreeNode root) {
        if (root == null) return 0;
        int leftLP = longestPath(root.left);
        int rightLP = longestPath(root.right);
        diameter = Math.max(leftLP + rightLP, diameter);
        return Math.max(leftLP, rightLP) + 1;
    }
}

// Runtime: 5ms
// Time: O(n)
// Space: O(n)
