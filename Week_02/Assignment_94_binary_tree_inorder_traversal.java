package Week_02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Assignment_94_binary_tree_inorder_traversal {
    /**
     * Description 验色标记术
     *
     * @author zhaolaiyuan
     * Date 2021/2/3 14:51
     **/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // 数组中有两个值，第一个值无意义仅作标记，为null表示未访问过
        Deque<TreeNode[]> stack = new LinkedList<>();
        stack.push(new TreeNode[]{null, root});
        TreeNode node;
        while (stack.size() > 0) {
            TreeNode[] arr = stack.pop();
            node = arr[1];
            if (node == null) {
                continue;
            }
            if (arr[0] == null) {
                // 没访问过
                stack.push(new TreeNode[]{null, node.right});
                stack.push(new TreeNode[]{root, node});
                stack.push(new TreeNode[]{null, node.left});
            } else {
                // 访问过
                result.add(node.val);
            }
        }

        return result;
    }

    ///////////////////////////////////////////

    /**
     * Description 递归
     *
     * @author zhaolaiyuan
     * Date 2021/2/3 13:47
     **/
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.inorderTraversal(result, root);

        return result;
    }

    private void inorderTraversal(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        this.inorderTraversal(result, node.left);
        result.add(node.val);
        this.inorderTraversal(result, node.right);

    }
}
