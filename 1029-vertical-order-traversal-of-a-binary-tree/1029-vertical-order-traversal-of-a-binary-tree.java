/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class CustomNode implements Comparable<CustomNode> {
    int col;
    TreeNode node;

    public CustomNode(TreeNode n, int c) {
        this.col = c;
        this.node = n;
    }

    public int compareTo(CustomNode other) {
        return this.col - other.col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<CustomNode> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> t = new TreeMap<>();
        q.offer(new CustomNode(root, 0));
        TreeMap<Integer, List<Integer>> columEle = null;
        List<Integer> levelEle = null;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                CustomNode n = q.poll();
                if (t.containsKey(n.col)) {
                    columEle = t.get(n.col);
                    levelEle = columEle.get(level);
                    if (levelEle != null) {
                        levelEle.add(n.node.val);
                    } else {
                        levelEle = new LinkedList<>();
                        levelEle.add(n.node.val);
                        columEle.put(level, levelEle);
                    }
                } else {
                    columEle = new TreeMap();
                    levelEle = new LinkedList<>();
                    levelEle.add(n.node.val);
                    columEle.put(level, levelEle);
                    t.put(n.col, columEle);
                }

                if (n.node.left != null) {
                    q.offer(new CustomNode(n.node.left, n.col - 1));
                }

                if (n.node.right != null) {
                    q.offer(new CustomNode(n.node.right, n.col + 1));
                }
            }
            level++;
        }

        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> e : t.entrySet()) {
            List<Integer> subarr = new ArrayList();
            for (Map.Entry<Integer, List<Integer>> le : e.getValue().entrySet()) {
                subarr.addAll(le.getValue().stream().sorted().collect(Collectors.toList()));
            }
            res.add(subarr);
        }
        return res;
    }
}