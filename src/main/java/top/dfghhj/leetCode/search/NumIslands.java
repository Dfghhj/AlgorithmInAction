package top.dfghhj.leetCode.search;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/9 21:08
 * @Description: 200.岛屿的个数
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
