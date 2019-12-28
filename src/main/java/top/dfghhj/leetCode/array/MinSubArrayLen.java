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

//    public int minSubArrayLen(int s, int[] nums) {
//        int i = 0;
//        int sum = 0;
//        int len = 0;
//        for (int j = 0; j < nums.length; j++) {
//            sum += nums[j];
//            while (sum >= s) {
//                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
//                sum -= nums[i++];
//            }
//        }
//        return len;
//    }
}
