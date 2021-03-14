package Week_06;

public class Assignment_647_palindromic_substrings {
    public int countSubstrings(String s) {
        int length = s.length();

        boolean[][] dp = new boolean[length][length];
        int count = 0;

        for (int l = 1; l <= length; l++) {
            for (int i = l - 1; i < length; i++) {
                if (l == 1) {
                    dp[i][i] = true;
                    count++;
                } else if (i - l + 1 >= 0 && s.charAt(i) == s.charAt(i - l + 1)) {
                    if (l == 2 || dp[i - l + 2][i - 1]) {
                        dp[i - l + 1][i] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Assignment_647_palindromic_substrings solution = new Assignment_647_palindromic_substrings();
        int aaa = solution.countSubstrings("aaa");
        System.out.println(aaa);
    }
}
