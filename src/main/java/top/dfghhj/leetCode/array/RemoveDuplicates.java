package top.dfghhj.leetCode.array;

/**
 * 26. 删除排序数组中的重复项
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[n]) {
                n++;
                nums[n] = nums[i];
            }
        }
        return n+1;
    }

//    public int removeDuplicates(int[] nums) {
//        for (int i=0; i<nums.length; i++) {
//            if (nums[i] == nums[nums.length-1]) return i+1;
//            int k = i+1;
//            while (nums[i] == nums[k]) {
//                k++;
//            }
//            for (int j = i+1; j < k; j++) {
//                nums[j] = nums[k];
//            }
//        }
//        return 0;
//    }
}
