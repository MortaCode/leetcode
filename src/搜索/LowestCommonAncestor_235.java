package 搜索;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor_235 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p_path = searchPath(root, p);
        List<TreeNode> q_path = searchPath(root, q);

        TreeNode ancestor = null;   //代码更优雅
        //都是从根节点出发
        for (int i=0; i<p_path.size() && i<q_path.size(); i++){
            if (p_path.get(i) == q_path.get(i)){
                ancestor = p_path.get(i);
            }
            //else{
            //    continue;   //没必要加continue，作用是跳出本次循环。但是已经是本次的最后了。  break是跳出循环
            //}
        }
        return ancestor;
    }

    public static List<TreeNode> searchPath(TreeNode root, TreeNode target){
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target){
            path.add(node);
            if (node.val < target.val){
                node = node.right;
            } else {
                node = node.left;
            }
        }
        path.add(node);//加上自己
        return path;
    }
}
