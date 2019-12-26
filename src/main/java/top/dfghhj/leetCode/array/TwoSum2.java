package top.dfghhj.leetCode.array;

/**
 * 167. 两数之和 II - 输入有序数组
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i<j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }
        }
        return result;
    }
}
