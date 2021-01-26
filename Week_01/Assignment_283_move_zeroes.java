package Week_01;


import java.util.Arrays;

public class Assignment_283_move_zeroes {
    public void moveZeroes(int[] nums) {
        // 第一个0的位置
        int zeroIndex = 0;
        // 最前面的索引
        int numIndex = 0;

        while (numIndex < nums.length) {
            if (nums[numIndex] != 0) {
                // 遇到非0的数时，
                if (zeroIndex != numIndex) {
                    nums[zeroIndex] = nums[numIndex];
                    nums[numIndex] = 0;
                }
                zeroIndex++;
            }
            numIndex++;
        }
    }

    public static void main(String[] args) {

        Assignment_283_move_zeroes solution = new Assignment_283_move_zeroes();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
