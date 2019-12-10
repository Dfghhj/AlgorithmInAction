package top.dfghhj.leetCode.stack;

import com.alibaba.fastjson.JSONObject;

import java.util.Stack;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/18 21:44
 * @Description: 739.每日温度
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(JSONObject.toJSONString(dailyTemperatures.dailyTemperatures(T)));
    }

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        int i = 0;
        while (i < T.length) {
            if (stack.isEmpty() || T[stack.peek()] >= T[i]) {
                stack.push(i);
                i++;
            } else {
                Integer index = stack.pop();
                res[index] = i - index;
            }
        }
        return res;
    }
}
