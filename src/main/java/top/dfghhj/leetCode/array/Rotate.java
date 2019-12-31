package top.dfghhj.leetCode.array;

/**
 * 189. 旋转数组
 */
public class Rotate {
    public int[] rotate(int[] nums, int k) {
        int temp;
        int length = nums.length;
        for (int i = 0; i < k; i++) {
            temp = nums[length -  1];
            for (int j = length-1; j >= 1; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
        return nums;
    }
}
