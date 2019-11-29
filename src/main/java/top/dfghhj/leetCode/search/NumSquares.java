package top.dfghhj.leetCode.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/12 21:18
 * @Description:
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 *   输入: n = 12
 *   输出: 3
 *   解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *   输入: n = 13
 *   输出: 2
 *   解释: 13 = 4 + 9.
 */
public class NumSquares {

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        long startTime = System.currentTimeMillis();
        System.out.println(numSquares.numSquares(13));
        System.out.println(numSquares.numSquares(12));
        System.out.println(numSquares.numSquares(1));
        System.out.println(numSquares.numSquares(4));
        System.out.println(numSquares.numSquares(9));
        System.out.println(numSquares.numSquares(7168));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }

    public int numSquares(int n) {
        Set<Integer> squareSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i=0;i<size;i++) {
                int now = queue.poll();
                if (squareSet.contains(now)) {
                    return step;
                }
                int max = (int)Math.sqrt(now);
                for (int j=max;j>0;j--) {
                    int square = j*j;
                    if (square == now) {
                        return step;
                    } else {
                        if (now == n) {
                            squareSet.add(square);
                        }
                        queue.add(now - square);
                    }
                }
            }
        }
        return -1;
    }
}
