package 搜索;

import common.TreeNode;

import java.util.*;

public class ZigzagLevelOrder_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){return result;}

        Deque<TreeNode> queue = new LinkedList<>();    //Queue队列  offer+poll   Deque双端队列  offer+poll  First/Last  pop
        queue.add(root);
        boolean isLeft = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();

                if (isLeft){
                    level.addFirst(node.val);
                } else {
                    level.addLast(node.val);
                }

                //正常入队
                if (node.left != null){queue.offer(node.left);}
                if (node.right != null){queue.offer(node.right);}
            }
            isLeft = !isLeft; //交替
            result.add(level);
        }
        return result;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){return result;}

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null){queue.offer(node.left);}
                if (node.right != null){queue.offer(node.right);}
                //queue.offer(node.left);
                //queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
