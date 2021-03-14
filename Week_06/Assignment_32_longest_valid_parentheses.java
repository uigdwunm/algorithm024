package Week_06;

public class Assignment_32_longest_valid_parentheses {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];

        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int last = i - dp[i - 1] - 1;
                if (last >= 0 && s.charAt(last) == '(') {
                    dp[i] = dp[i - 1] + 2 + (last > 0 ? dp[last - 1] : 0);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
