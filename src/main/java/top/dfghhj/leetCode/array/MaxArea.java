package top.dfghhj.leetCode.array;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/8 21:23
 * @Description: 11.盛最多水的容器
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
