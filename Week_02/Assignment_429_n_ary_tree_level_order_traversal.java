package Week_02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Assignment_429_n_ary_tree_level_order_traversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        while (deque.size() > 0) {
            int l = deque.size();
            List<Integer> list = new ArrayList<>(l);
            for (int i = 0; i < l; i++) {
                Node node = deque.removeFirst();
                list.add(node.val);
                node.children.forEach(deque::addLast);
            }
            result.add(list);
        }
        return result;
    }
}
