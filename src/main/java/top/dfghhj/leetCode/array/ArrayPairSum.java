package top.dfghhj.leetCode.array;

/**
 * 561. 数组拆分 I
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
//        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 -i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        int result = 0;
        for (int i = 0; i<nums.length; i+=2) {
            result += nums[i];
        }
        return result;
    }
}
