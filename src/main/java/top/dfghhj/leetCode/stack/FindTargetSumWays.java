package top.dfghhj.leetCode.stack;

import top.dfghhj.leetCode.Test;

/**
 * @Author: Dfghhj
 * @Date: 2019/12/9 21:44
 * @Description: leetcode.494 目标和
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        FindTargetSumWays test = new FindTargetSumWays();
        long startTime = System.currentTimeMillis();
        System.out.println(test.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }


    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 1) {
            if (nums[0] == S && S == 0) {
                return 2;
            }
            if (nums[0] == S || nums[0] == -S) {
                return 1;
            }
            return 0;
        } else {
            int[] newNums = new int[nums.length-1];
            for (int i = 0; i< newNums.length; i++) {
                newNums[i] = nums[i];
            }
            return findTargetSumWays(newNums, S - nums[nums.length-1]) + findTargetSumWays(newNums, S + nums[nums.length-1]);
        }
    }
}
