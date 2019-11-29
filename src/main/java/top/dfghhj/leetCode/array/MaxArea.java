package top.dfghhj.leetCode.array;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/8 21:23
 * @Description:
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 示例:
 *   输入: [1,8,6,2,5,4,8,3,7]
 *   输出: 49
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(nums));
    }

    public int maxArea(int[] height) {
        int area = 0;
        int head = 0;
        int foot = height.length-1;
        while (head < foot) {
            int a = height[head];
            int b = height[foot];
            int newArea;
            if (a > b) {
                newArea = b * (foot-head);
                foot--;
            } else {
                newArea = a * (foot-head);
                head++;
            }
            if (newArea > area) {
                area = newArea;
            }
        }
        return area;
    }
}
