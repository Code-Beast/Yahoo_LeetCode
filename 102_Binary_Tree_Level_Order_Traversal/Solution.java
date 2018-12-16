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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        res.add(Arrays.asList(root.val));
        
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int currQueueSize = queue.size();
            for (int i = 0; i < currQueueSize; i ++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.addLast(currNode.left);
                    currLevel.add(currNode.left.val);
                }
                if (currNode.right != null) {
                    queue.addLast(currNode.right);
                    currLevel.add(currNode.right.val);
                }
            }
            if (!currLevel.isEmpty())
                res.add(currLevel);
        }
        
        return res;
    }
}

// Runtime: 1ms