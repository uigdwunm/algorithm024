package Week_04;

public class Assignment_33_search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        if (target > nums[left]) {
            // 结果在左半部分
            // 左半部分二分
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] < nums[0] || nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
        } else if (target < nums[left]) {
            // 结果在右半部分
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] >= nums[0] || nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
        } else {
            return left;
        }

        return -1;
    }


    public static void main(String[] args) {
        Assignment_33_search_in_rotated_sorted_array solution = new Assignment_33_search_in_rotated_sorted_array();
        int[] nums = {4,5,6,7,8,1,2,3};
        int search = solution.search(nums, 8);
        System.out.println(search);
    }
}
