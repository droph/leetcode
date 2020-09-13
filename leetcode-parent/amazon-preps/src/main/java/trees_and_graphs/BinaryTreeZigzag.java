package trees_and_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        var letters = new List[25];
        var order = new ArrayList<List<Integer>>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(false, root));
        order.add(List.of(root.val));
        while (!queue.isEmpty()) {
            var pair = queue.poll();
            var list = new ArrayList<Integer>();
            var left = pair.node.left;
            var right = pair.node.right;
            if (pair.fromLeft) {
                if (left != null) {
                    list.add(left.val);
                }
                if (right != null) {
                    list.add(right.val);
                }
            } else {
                if (right != null) {
                    list.add(right.val);
                }
                if (left != null) {
                    list.add(left.val);
                }
            }
            if (left != null) {
                queue.offer(new Pair(!pair.fromLeft, left));
            }

            if (right != null) {
                queue.offer(new Pair(!pair.fromLeft, right));
            }
        }
        return order;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        public boolean fromLeft;
        public TreeNode node;

        public Pair(boolean fromLeft, TreeNode node) {
            this.fromLeft = fromLeft;
            this.node = node;
        }
    }
}
