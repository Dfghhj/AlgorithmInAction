package top.dfghhj.leetCode.array;

/**
 * 283. 移动零
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
            if (i == nums.length-1) {
                for (int j = k; j <= i; j++){
                    nums[j] = 0;
                }
            }
        }
    }
}
