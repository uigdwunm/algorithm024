package Week_02;

import java.util.HashMap;
import java.util.Map;

public class Assignment_1_two_sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer ii = map.get(target - num);
            if (ii != null) {
                return new int[]{ii, i};
            } else {
                map.put(num, i);
            }
        }
        return null;
    }
}
