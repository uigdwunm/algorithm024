package Week_03;

import java.util.*;
import java.util.stream.Collectors;

public class Assignment_46_permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return Collections.emptyList();
        }

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        List<List<Integer>> result = new LinkedList<>();
        this.dfs(list, 0, result);

        return result;
    }

    private void dfs(List<Integer> list, int index, List<List<Integer>> result) {
        int size = list.size();
        if (size == index) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < size; i++) {
            Collections.swap(list, index , i);
            this.dfs(list, index + 1, result);
            Collections.swap(list, index , i);
        }
    }
}
