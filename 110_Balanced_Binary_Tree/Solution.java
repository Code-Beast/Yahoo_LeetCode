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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}

// Runtime: 1ms
// Time: O(n^2)
// Space: O(n^2)



class Solution {
    private boolean result = true;
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int height = getHeight(root);
        return result;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) result = false;
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

// Runtime: 1ms
// Time: O(n)
// Space: O(n)



class Solution {public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfsHeight(root) != -1; 
    }
    
    private int dfsHeight(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

// Runtime: 1ms
// Time: O(n)
// Space: O(n)
