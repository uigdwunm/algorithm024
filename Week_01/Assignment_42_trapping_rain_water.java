package Week_01;

public class Assignment_42_trapping_rain_water {

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        // 循环过程中的左指针
        int l = 0;
        // 循环过程中的右指针
        int r = height.length - 1;

        int floor = 0;
        // 记录雨水数量(过程中会把方块和雨水全记录)
        int count = this.computeCount(l, r, height, floor);
        // 较低的作为地基高度
        floor = Math.min(height[l], height[r]);

        while (l < r) {
            if (height[l] > floor && height[r] > floor) {
                // 都高于地基
                count += this.computeCount(l, r, height, floor);
                floor = Math.min(height[l], height[r]);
            } else if (height[l] > floor) {
                // 仅左边高于地基，动右边
                count -= height[r];
                r--;
            } else if (height[r] > floor) {
                // 仅右边高于地基，动左边
                count -= height[l];
                l++;
            } else {
                // 两边都不高于地基
                count -= height[l];
                count -= height[r];
                l++;
                r--;
            }
        }

        // 如果左右指针最后停在一起，则会少处理这个值
        if (l == r) {
            // 高于地基是没有意义的
            count -= Math.min(height[l], floor);
        }

        return count;

    }

    // 计算这个方块的面积，包括边界墙，但是会减去地基
    private int computeCount(int l, int r, int[] height, int floor) {
        return (Math.min(height[l], height[r]) - floor) * (r - l + 1);
    }
}
