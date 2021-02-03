package Week_02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Assignment_144_binary_tree_preorder_traversal {
    /**
     * Description 迭代
     *
     * @author zhaolaiyuan
     * Date 2021/2/3 13:38
     **/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode node;
        while (stack.size() > 0) {
            node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    ////////////////////////////////////////////////////

    /**
     * Description 递归
     *
     * @author zhaolaiyuan
     * Date 2021/2/3 13:38
     **/
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        this.preorderTraversal2(result, root);
        return result;
    }

    public void preorderTraversal2(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        this.preorderTraversal2(result, root.left);
        this.preorderTraversal2(result, root.right);

    }

}
