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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> levelQ = new LinkedList<>();
        levelQ.offer(root);

        TreeNode t = null;

        while(!levelQ.isEmpty()) {
            int size = levelQ.size();
            while(size-- > 0) {
                t = levelQ.poll();
                if(t.left != null) {
                    levelQ.offer(t.left);
                }
                if(t.right != null) {
                    levelQ.offer(t.right);
                }
            }
            if(size == -1) {
                res.add(t.val);
            }
        }
        return res;
    }
}