使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
找到分界线处的索引。

```java
class Solution {
    public int find(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            // 一个数或零个数没得找
            return -1;
        }
        int left = 0;
        int right = len - 1;

        // 先确保有答案(保证尾部大于头部，即有无序的地方)（因为二分里有+1的操作可能越界）
        if (nums[right] >= nums[left]) {
            return -1;
        }

        int mid;

        // 记录首位数，辅助判断
        int first = nums[0];

        // 二分模板
        while (left <= right) {
            mid = left + (right - left) / 2;

            // 只要当前位置大于首值，下一个位置小于首值，就是分界点
            if (nums[mid] >= first && nums[mid + 1] < first) {
                return mid + 1;
            } else if (nums[mid] < first) {
                // 中值在右半部分就向左找
                right = mid - 1;
            } else {
                // 中值在左半部分就向左找
                left = mid + 1;
            }
        }

        // 这个其实不会调到，因为确保有答案了
        return -1;
    }
}
```
