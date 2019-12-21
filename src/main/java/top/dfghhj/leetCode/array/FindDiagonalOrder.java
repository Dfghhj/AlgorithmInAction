package top.dfghhj.leetCode.array;

/**
 * 498. 对角线遍历
 */
public class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return new int[0];
        }
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int row = 0;
        int col = 0;
        // 1:右上;2:右;3:左下;4:下
        int before = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[row][col];
            if (before == 1) {
                if (col == cols-1) {
                    row++;
                    before = 4;
                } else if (row == 0) {
                    col++;
                    before = 2;
                } else {
                    row--;
                    col++;
                    before = 1;
                }
            } else if (before == 2) {
                if (rows == 1) {
                    col++;
                    before = 2;
                }else if (row == 0) {
                    row++;
                    col--;
                    before = 3;
                } else {
                    row--;
                    col++;
                    before = 1;
                }
            } else if (before == 3) {
                if (row == rows-1) {
                    col++;
                    before = 2;
                } else if (col == 0) {
                    row++;
                    before = 4;
                } else {
                    row++;
                    col--;
                    before = 3;
                }
            } else {
                if (cols == 1) {
                    row++;
                    before = 4;
                }else if (col == 0) {
                    row--;
                    col++;
                    before = 1;
                } else {
                    row++;
                    col--;
                    before = 3;
                }
            }
        }
        return result;
    }
}
