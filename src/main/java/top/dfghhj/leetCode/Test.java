package top.dfghhj.leetCode;

import top.dfghhj.leetCode.search.NumSquares;

import java.util.*;

/**
 * @author ：feifeng
 * @date ：Created in 2019/12/9 14:52
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        long startTime = System.currentTimeMillis();
        test.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }


    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if (S > sum) {
            return 0;
        }
        if (nums.length == 2) {
            if (nums[0] + nums[1] == S) {
                System.out.println("-------:" + 1);
                return 1;
            }
            return 0;
        }
        int[] newNums = new int[nums.length-1];
        for (int i = 0; i < newNums.length; i++) {
            newNums[i] = nums[i];
        }
        return findTargetSumWays(newNums, S - nums[nums.length-1]) + findTargetSumWays(newNums, S + nums[nums.length-1]);
    }

}
