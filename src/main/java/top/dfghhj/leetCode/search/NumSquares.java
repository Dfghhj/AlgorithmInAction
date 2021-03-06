package top.dfghhj.leetCode.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/12 21:18
 * @Description: 279.完全平方数
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

    /**
     * 拉格朗日4数平方和定理
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        while (n % 4 == 0){
            n /= 4;
        }
        if (n % 8 == 7){
            return 4;
        }
        for (int a = 0; a*a <= n; ++a){
            int b = (int)Math.sqrt(n - a*a);
            if (a*a + b*b == n){
                return a==0?1:2;
            }
        }
        return 3;
    }
}
