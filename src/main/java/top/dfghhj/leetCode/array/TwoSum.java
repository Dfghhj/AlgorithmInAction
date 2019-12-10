package top.dfghhj.leetCode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Dfghhj
 * @Date: 2019/3/30 16:48
 * @Description: 1.两数之和
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
