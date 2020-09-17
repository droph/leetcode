package arrays_and_strings;

import java.util.LinkedList;
import java.util.Queue;

public class FindInBST {
    public static void main(String[] args) {

        var treeNode = new TreeNode(0, new TreeNode(-1, new TreeNode(-3), null), new TreeNode(2, null, new TreeNode(4)));
        System.out.println(new FindInBST().findTarget(treeNode, -4));
    }

    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            var toFind = k - node.val;
            var internalNode = root;
            while (internalNode != null) {
                if (internalNode.val == toFind && !internalNode.equals(node)) {
                    return true;
                } else if (internalNode.val > toFind) {
                    internalNode = internalNode.left;
                } else {
                    internalNode = internalNode.right;
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
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
}
