/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        boolean foundP = false;
        TreeNode currNode = root;
        
        while (currNode.left != null || !stack.isEmpty()) {
            while (currNode.left != null) {
                stack.push(currNode.left);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            if (foundP == true) return currNode;
            if (currNode == p) foundP = true;
            if (currNode.right != null) {
                stack.push(currNode.right);
                currNode = currNode.right;
            }
        }
        
        return null;
    }
}

// Runtime: 1700ms



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    
    private TreeNode preNode;
    private TreeNode sucNode;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) return null;
        inorder(root, p);
        return sucNode;
    }
    
    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        
        inorder(root.left, p);
        
        if (preNode == p) sucNode = root;
        preNode = root;

        inorder(root.right, p);
    }
}

// Runtime: 1836ms



public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    
    private TreeNode preNode;
    private TreeNode sucNode;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) return null;
        inorder(root, p);
        return sucNode;
    }
    
    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        
        if (root.val > p.val || preNode == p) inorder(root.left, p);
        
        if (preNode == p) sucNode = root;
        preNode = root;
        
        if (root.val < p.val || preNode == p) inorder(root.right, p);
    }
}

// Runtime: 1843ms



public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
     
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        boolean foundP = false;
        TreeNode res = null;
        
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return res;
    }
}

// Runtime: 1834ms




