package Week_04;

public class Assignment_search_a_2d_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int xl = matrix.length;
        int yl = matrix[0].length;

        // 确保在范围内
        if (matrix[0][0] > target && matrix[xl - 1][yl - 1] < target) {
            return false;
        }

        int left = 0;
        int right = xl - 1;
        int mid;

        int xi = 0;
        // 先纵向找
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (matrix[mid][0] <= target && matrix[mid][yl - 1] >= target) {
                xi = mid;
                break;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        // 再横向找
        left = 0;
        right = yl - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (matrix[xi][mid] == target) {
                return true;
            } else if (matrix[xi][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
