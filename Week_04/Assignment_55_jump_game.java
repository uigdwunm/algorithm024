package Week_04;

public class Assignment_55_jump_game {
    public boolean canJump(int[] nums) {
        // 最后一个下标
        int end = nums.length - 1;
        if (nums.length == 1) {
            return true;
        }

        // 当前循环到哪个位置了
        int i = 1;
        // 当前能到达的最大索引位置
        int max = nums[0];

        while (max >= i) {
            if (max >= end) {
                return true;
            }
            max = Math.max(max, i + nums[i]);
            i++;
        }
        return false;
    }
}
