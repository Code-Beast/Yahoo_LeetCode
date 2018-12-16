/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(',');
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        
        while (!queue.isEmpty()) {
            root = queue.removeFirst();
            if (root.left == null) sb.append("#,");
            else {
                sb.append(root.left.val);
                sb.append(',');
                queue.addLast(root.left);
            }
            
            if (root.right == null) sb.append("#,");
            else {
                sb.append(root.right.val);
                sb.append(',');
                queue.addLast(root.right);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.charAt(0) == '#') return null;
        
        String[] nodeArr = data.split(",", 0);
        TreeNode root = new TreeNode(Integer.valueOf(nodeArr[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        
        int i = 0;
        int val = 0;
        String nodeVal = "";
        while (!queue.isEmpty()) {
            TreeNode thisRoot = queue.removeFirst();
            i ++;
            nodeVal = nodeArr[i];
            if (nodeVal.equals("#")) {
                thisRoot.left = null;
            } else {
                thisRoot.left = new TreeNode(Integer.valueOf(nodeArr[i]));
                queue.addLast(thisRoot.left);
            }
            
            i ++;
            nodeVal = nodeArr[i];
            if (nodeVal.equals("#")) {
                thisRoot.right = null;
            } else {
                thisRoot.right = new TreeNode(Integer.valueOf(nodeArr[i]));
                queue.addLast(thisRoot.right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// Runtim: 23ms
// Use Integer.parseInt(str) can reduce the time to 14ms



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }
    
    private void serializeDFS(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val);
        sb.append(' ');
        serializeDFS(root.left, sb);
        serializeDFS(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodeList = new LinkedList<String>(Arrays.asList(data.split(" ", 0)));
        if (data.charAt(0) == '#') return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodeList.remove(0)));
        deserializeDFS(root, nodeList);
        return root;
    }
    
    private void deserializeDFS(TreeNode root, List<String> list) {
        if (list.get(0).equals("#")) {
            root.left = null;
            list.remove(0);
        } else {
            root.left = new TreeNode(Integer.parseInt(list.remove(0)));
            deserializeDFS(root.left, list);
        }
        
        if (list.get(0).equals("#")) {
            root.right = null;
            list.remove(0);
        } else {
            root.right = new TreeNode(Integer.parseInt(list.remove(0)));
            deserializeDFS(root.right, list);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// Runtime: 10ms



