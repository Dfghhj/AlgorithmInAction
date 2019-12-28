package top.dfghhj.leetCode.array;

/**
 * 485. 最大连续1的个数
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                k++;
            } else {
                if (k > result) {
                    result = k;
                }
                k = 0;
            }
        }
        if (k > result) {
            result = k;
        }
        return result;
    }
}
