package Week_03;

import Week_02.Assignment_94_binary_tree_inorder_traversal;
import Week_02.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment_105_construct_binary_tree_from_preorder_and_inorder_traversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return this.buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private Map<Integer, Integer> inorderMap = new HashMap<>();

    private TreeNode buildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (psi > pei) {
            return null;
        }
        if (psi == pei) {
            return new TreeNode(preorder[psi]);
        }
        int val = preorder[psi];
        TreeNode node = new TreeNode(val);
        int ii = inorderMap.get(val);

        int ll = ii - isi;
        node.left = this.buildTree(preorder, psi + 1, psi + ll, inorder, isi, ii - 1);

        int rl = iei - ii;
        node.right = this.buildTree(preorder, pei - rl + 1, pei, inorder, ii + 1, iei);
        return node;
    }

    public static void main(String[] args) {
        Assignment_105_construct_binary_tree_from_preorder_and_inorder_traversal solution = new Assignment_105_construct_binary_tree_from_preorder_and_inorder_traversal();
        int[] preorder = {1,2};
        int[] inorder = {2,1};
        TreeNode treeNode = solution.buildTree(preorder, inorder);

        Assignment_94_binary_tree_inorder_traversal inorder_traversal = new Assignment_94_binary_tree_inorder_traversal();
        List<Integer> integers = inorder_traversal.inorderTraversal(treeNode);
        System.out.println(integers);
    }

}
