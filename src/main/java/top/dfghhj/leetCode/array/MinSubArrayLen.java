package top.dfghhj.leetCode.array;

/**
 * 209. 长度最小的子数组
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = i;
            int sum = 0;
            while (sum < s) {
                if (k == nums.length) break;
                sum += nums[k];
                k++;
            }
            if (sum >= s && (result == 0 || result > k - i)) {
                result = k - i;
            }
        }
        return result;
    }
}
