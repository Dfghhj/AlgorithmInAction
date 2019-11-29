package top.dfghhj.leetCode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Dfghhj
 * @Date: 2019/3/30 16:48
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 *   给定 nums = [2, 7, 11, 15], target = 9
 *   因为 nums[0] + nums[1] = 2 + 7 = 9
 *   所以返回 [0, 1]
 *
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++) {
            int number = nums[i];
            int other = target - number;
            Integer old = map.get(other);
            if (old != null) {
                result[0] = old;
                result[1] = i;
                return result;
            } else {
                map.put(number, i);
            }
        }
        return result;
    }
}
