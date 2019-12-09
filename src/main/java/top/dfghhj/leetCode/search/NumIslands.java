package top.dfghhj.leetCode.search;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/9 21:08
 * @Description:
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 示例 1:
 *   输入:
 *     11110
 *     11010
 *     11000
 *     00000
 *   输出: 1
 *
 * 示例 2:
 *   输入:
 *     11000
 *     11000
 *     00100
 *     00011
 *   输出: 3
 */
public class NumIslands {

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();

        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
        System.out.println(numIslands.numIslands(grid));

        char[][] grid1 = {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}};
        System.out.println(numIslands.numIslands(grid1));
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        int rows = grid.length;
        if ( rows > 0) {
            int cols = grid[0].length;
            if (cols > 0) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (grid[i][j] == '1') {
                            result ++ ;
                            findLand(i, j, rows, cols, grid);
                        }
                    }
                }
            }
        }
        return result;
    }

    private void findLand(int rowNumber, int colNumber, int rows, int cols, char[][] grid) {
        if(grid[rowNumber][colNumber]!='1'){
            return;
        }
        grid[rowNumber][colNumber] = '0';
        if (rowNumber+1 < rows) {
            findLand(rowNumber+1, colNumber, rows, cols, grid);
        }
        if (rowNumber-1 >= 0) {
            findLand(rowNumber-1, colNumber, rows, cols, grid);
        }
        if (colNumber+1 < cols) {
            findLand(rowNumber, colNumber+1, rows, cols, grid);
        }
        if (colNumber-1 >= 0) {
            findLand(rowNumber, colNumber-1, rows, cols, grid);
        }
    }
}
