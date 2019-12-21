package top.dfghhj.leetCode.array;

/**
 * 747. 至少是其他数字两倍的最大数
 */
public class DominantIndex {

    public int dominantIndex(int[] nums) {
        int max = 0, doubleNum = 0;
        int maxIndex = 0 ;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                doubleNum = max * 2;
                max = nums[i];
                maxIndex = i;
            } else if (2 * nums[i] > doubleNum) {
                doubleNum = 2 * nums[i];
            }
        }
        if (max > doubleNum) return maxIndex;
        return -1;
    }
}
