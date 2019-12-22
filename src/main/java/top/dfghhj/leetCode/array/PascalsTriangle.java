package top.dfghhj.leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118.杨辉三角
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=1; i <= numRows; i++) {
            List<Integer> nowList = new ArrayList<>(i);
            for (int j=0; j<i; j++) {
                if (j == 0 || j == i-1) {
                    nowList.add(j, 1);
                } else {
                    nowList.add(j, result.get(i-2).get(j-1) + result.get(i-2).get(j));
                }
            }
            result.add(nowList);
        }
        return result;
    }
}
