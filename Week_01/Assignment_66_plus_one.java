package Week_01;

public class Assignment_66_plus_one {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        // 第一推动力，加一
        digits[l - 1]++;
        // 倒序循环
        for (int i = l - 2; i > -1; i--) {
            // 判断后面一个是否需要进位
            if (digits[i + 1] > 9) {
                // 需要进位
                digits[i + 1] = 0;
                digits[i]++;
            } else {
                break;
            }
        }
        // 超出极限的情况，9，99，999，9999，加一后数组需要扩容。
        if (digits[0] > 9) {
            digits = new int[l + 1];
            digits[0] = 1;
            return digits;
        }
        return digits;
    }
}
