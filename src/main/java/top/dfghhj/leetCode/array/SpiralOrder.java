package top.dfghhj.leetCode.array;

import java.util.*;

/**
 *  54.螺旋矩阵
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return Collections.emptyList();
        }
        int cols = matrix[0].length;
        int[][] operates = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int operate = 0;
        List<Integer> result = new ArrayList<>(rows * cols);
        Set<String> used = new HashSet<>();
        int row = 0;
        int col = 0;

        int nextRow;
        int nextCol;

        for (int i = 0; i < rows * cols; i++) {
            result.add(matrix[row][col]);
            used.add(row+"_"+col);

            nextRow = row + operates[operate][0];
            nextCol = col + operates[operate][1];
            String index = nextRow + "_" + nextCol;
            if (used.contains(index)
                    || (row == 0 && col == cols - 1)
                    || (row == rows - 1 && col == cols - 1)
                    || (row == rows - 1 && row > 0 && col == 0)) {
                operate = ( operate + 1 ) % 4;
                nextRow = row + operates[operate][0];
                nextCol = col + operates[operate][1];
            }
            row = nextRow;
            col = nextCol;
        }
        return result;
    }
}
