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
        if (rows > 0) {
            int columns = grid[0].length;
            if (columns > 0) {
                for (int i=0;i<rows;i++) {
                    for (int j=0;j<columns;j++) {
                        if (grid[i][j] == '1') {
                            result++;
                            toZero(grid,i,j,rows,columns);
                        }
                    }
                }
            }
        }
        return result;
    }

    private void toZero(char[][] grid,int i,int j,int rows,int columns){
        if(i<0 || i>=rows || j<0 || j>=columns){
            return ;
        }
        if(grid[i][j]!='1'){
            return;
        }
        grid[i][j]='0';
        toZero(grid,i+1,j,rows,columns);
        toZero(grid,i-1,j,rows,columns);
        toZero(grid,i,j+1,rows,columns);
        toZero(grid,i,j-1,rows,columns);
    }
}
