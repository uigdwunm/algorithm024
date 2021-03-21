package Week_07;

public class Assignment_70_climbing_stairs {
    public int climbStairs(int n) {
        if (n < 4) {
            return n;
        }

        int one = 1;
        int two = 2;
        int three = 3;
        for (int i = 2; i < n; i++) {
            three = one + two;
            one = two;
            two = three;
        }

        return three;
    }
}
