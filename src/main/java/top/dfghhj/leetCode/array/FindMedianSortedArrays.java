package top.dfghhj.leetCode.array;

/**
 * @author ：feifeng
 * @date ：Created in 2019/4/3 16:58
 * @description:
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 *   nums1 = [1, 3]
 *   nums2 = [2]
 *   则中位数是 2.0
 * 示例 2:
 *   nums1 = [1, 2]
 *   nums2 = [3, 4]
 *   则中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        int b = length / 2;
        int[] add = new int[b+1];
        boolean isEven;
        if (length % 2 == 1) {
            isEven = false;
        } else {
            isEven = true;
        }
        for (int i=0,m1=0,n1=0;i<length;i++) {
            int num1 = 0;
            if (m1 < m) {
                num1 = nums1[m1];
            }
            int num2 = 0;
            if (n1 < n) {
                num2 = nums2[n1];
            }
            if (m1 == m) {
                add[i] = num2;
                n1++;
            } else if (n1 == n) {
                add[i] = num1;
                m1++;
            } else {
                if (num1 > num2) {
                    add[i] = num2;
                    n1++;
                } else {
                    add[i] = num1;
                    m1++;
                }
            }
            if (i==b) {
                if (isEven) {
                    return (add[i] + add[i-1]) / 2.0;
                } else {
                    return add[i];
                }
            }
        }
        return 0.0;
    }
}
