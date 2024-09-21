/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int level = 0;

        Queue<TreeNode> levelNode = new LinkedList<>();
        levelNode.offer(root);

        while(!levelNode.isEmpty()) {
            int levelNodeCount = levelNode.size();
            while(levelNodeCount-- > 0) {
                TreeNode temp = levelNode.poll();
                if(temp.left != null)
                    levelNode.offer(temp.left);
                
                if(temp.right != null)
                    levelNode.offer(temp.right);
            }
            level++;
        }

        return level;
    }
}