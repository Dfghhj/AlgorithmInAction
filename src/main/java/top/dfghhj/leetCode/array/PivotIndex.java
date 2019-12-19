package top.dfghhj.leetCode.array;

/**
 * @Author: Dfghhj
 * @Date: 2019/12/19 22:39
 * @Description: 724. 寻找数组的中心索引
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * a + nums[i] == sum) {
                return i;
            }
            a += nums[i];
        }
        return -1;

    }
}
