package Week_04;

public class Assignment_153_find_minimum_in_rotated_sorted_array {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int first = nums[left];
        // 判断有没有进行过旋转
        if (first <= nums[right]) {
            return nums[left];
        }
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] >= first && nums[mid + 1] < first) {
                return nums[mid + 1];
            } else if (nums[mid] < first) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
