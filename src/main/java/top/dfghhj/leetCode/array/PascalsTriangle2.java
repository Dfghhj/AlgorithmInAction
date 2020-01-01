package top.dfghhj.leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 */
public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex+1);
        for(int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    result.add(j, 1);
                } else if (j > 0) {
                    result.add(j, result.remove(j) + result.get(j-1));
                }
            }
        }
        return result;
    }
}
