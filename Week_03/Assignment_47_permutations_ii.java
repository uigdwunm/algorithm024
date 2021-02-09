package Week_03;

import java.util.*;
import java.util.stream.Collectors;

public class Assignment_47_permutations_ii {
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> deque = Arrays.stream(nums).sorted().boxed().collect(Collectors.toCollection(LinkedList::new));
        List<List<Integer>> result = new LinkedList<>();
        this.dfs(result, new LinkedList<>(), deque);

        return result;
    }

    private void dfs(List<List<Integer>> result, Deque<Integer> list, Deque<Integer> deque) {
        int l = deque.size();
        if (l == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        Integer last = null;

        for (int j = 0; j < l; j++) {
            Integer num = deque.removeFirst();

            if (num.equals(last)) {
                deque.addLast(num);
                continue;
            }
            list.addLast(num);
            this.dfs(result, list, deque);
            list.removeLast();
            deque.addLast(num);
            last = num;
        }
    }
}
