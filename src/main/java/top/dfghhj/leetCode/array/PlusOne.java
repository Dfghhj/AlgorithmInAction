package top.dfghhj.leetCode.array;

/**
 * 66. 加一
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int oldLength = digits.length;
        int[] newDigits = new int[oldLength + 1];
        boolean isAddOne = true;
        for (int i = oldLength; i >= 0; i--) {
            if (isAddOne) {
                if (i == 0) {
                    newDigits[i] = 1;
                } else {
                    int sum = digits[i - 1] + 1;
                    if (sum == 10) {
                        newDigits[i] = 0;
                    } else {
                        newDigits[i] = sum;
                        isAddOne = false;
                    }
                }
            } else if (i > 0) {
                newDigits[i] = digits[i-1];
            }
        }
        if (newDigits[0] > 0) return newDigits;
        int[] result = new int[oldLength];
        for (int j = 1; j <= oldLength; j++) {
            result[j-1] = newDigits[j];
        }
        return result;
    }
}
