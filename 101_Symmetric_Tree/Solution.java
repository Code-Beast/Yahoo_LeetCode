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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;
        
        return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left);
    }
}

// Runtime: 10ms
// Time: O(n)
// Space: O(n)



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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();
        
        stackLeft.push(root.left);
        stackRight.push(root.right);
        
        while (stackLeft.size() != 0) {
            TreeNode leftNode = stackLeft.peek();
            TreeNode rightNode = stackRight.peek();
            
            if (leftNode != null && rightNode == null || leftNode == null && rightNode != null) return false;
            
            if (leftNode == null && rightNode == null) {
                stackLeft.pop();
                stackRight.pop();
            } else if (leftNode.val != rightNode.val) {
                return false;
            } else {
                stackLeft.pop();
                stackRight.pop();
                stackLeft.push(leftNode.left);
                stackRight.push(rightNode.right);
                stackLeft.push(rightNode.left);
                stackRight.push(leftNode.right);
            }
        }
        
        return true;
    }
}

// Runtime: 10ms
// Time: O(n)
// Space: O(n)
