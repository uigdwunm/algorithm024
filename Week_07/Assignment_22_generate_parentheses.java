package Week_07;

import java.util.LinkedList;
import java.util.List;

public class Assignment_22_generate_parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        this.dfs(result, 0, n, n, new char[n * 2]);

        return result;
    }

    private void dfs(List<String> result, int i, int left, int right, char[] curr) {
        if (i == curr.length) {
            result.add(new String(curr));
            return;
        }

        if (left > 0) {
            curr[i] = '(';
            this.dfs(result, i + 1, left - 1, right, curr);
        }
        if (right > left) {
            curr[i] = ')';
            this.dfs(result, i + 1, left, right - 1, curr);
        }
    }
}
