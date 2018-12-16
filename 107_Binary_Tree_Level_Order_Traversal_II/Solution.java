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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, TreeNode root, int currLayer) {
        if (root == null) return;
        
        currLayer ++;
        if (currLayer > res.size()) {
            res.add(0, new ArrayList<Integer>());
        }
        res.get(res.size() - currLayer).add(root.val);
        helper(res, root.left, currLayer);
        helper(res, root.right, currLayer);
        
        return;
    }
}

// Runtime: 1ms
// Time: O(n^2)
// Space: O(n)
