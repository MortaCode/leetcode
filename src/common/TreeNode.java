package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(){}

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 从层序遍历数组构建二叉树
     * @param levelOrder 层序遍历数组，使用null表示空节点
     * @return 构建的树根节点
     */
    public TreeNode buildTree(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0] == null) {
            return null;
        }

        // 创建根节点
        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;  // 数组索引
        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode node = queue.poll();

            // 构建左子节点
            if (i < levelOrder.length && levelOrder[i] != null) {
                node.left = new TreeNode(levelOrder[i]);
                queue.offer(node.left);
            }
            i++;

            // 构建右子节点
            if (i < levelOrder.length && levelOrder[i] != null) {
                node.right = new TreeNode(levelOrder[i]);
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    // 测试
//        public static void main(String[] args) {
//            BuildTreeFromLevelOrder builder = new BuildTreeFromLevelOrder();
//
//            // 构建树：     1
//            //            / \
//            //           2   3
//            //          / \   \
//            //         4   5   6
//            Integer[] levelOrder = {1, 2, 3, 4, 5, null, 6};
//
//            TreeNode root = builder.buildTree(levelOrder);
//
//            // 验证：重新层序遍历输出
//            List<List<Integer>> result = levelOrderTraversal(root);
//            System.out.println("重建后的层序遍历结果：");
//            for (List<Integer> level : result) {
//                System.out.println(level);
//            }
//        }
//
//        // 验证用的层序遍历
//        private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
//            List<List<Integer>> result = new ArrayList<>();
//            if (root == null) return result;
//
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.offer(root);
//
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                List<Integer> level = new ArrayList<>();
//
//                for (int i = 0; i < size; i++) {
//                    TreeNode node = queue.poll();
//                    level.add(node.val);
//
//                    if (node.left != null) queue.offer(node.left);
//                    if (node.right != null) queue.offer(node.right);
//                }
//                result.add(level);
//            }
//            return result;
//        }
//    }


}
