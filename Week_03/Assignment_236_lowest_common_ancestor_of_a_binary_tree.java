package Week_03;

import Week_03.TreeNode;

public class Assignment_236_lowest_common_ancestor_of_a_binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return result == null ? root : result;
    }
    private TreeNode result;

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (this.result != null) {
            return 2;
        } else if (root == null) {
            return 0;
        }

        int i = 0;
        if (root == p) {
            i++;
        } else if (root == q) {
            i++;
        }

        i += this.dfs(root.left, p, q);
        if (this.result == null && i == 2) {
            this.result = root;
            return i;
        }
        i += this.dfs(root.right, p, q);
        if (this.result == null && i == 2) {
            this.result = root;
            return i;
        }
        return i;
    }
}
