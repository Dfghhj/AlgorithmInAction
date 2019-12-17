package top.dfghhj.leetCode.stack;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Dfghhj
 * @Date: 2019/12/17 21:22
 * @Description: 733. 图像渲染
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Set<String> used = new HashSet<>();
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            floodFill2(image, sr, sc, newColor, oldColor, used);
        }
        return image;
    }

    private void floodFill2(int[][] image, int sr, int sc, int newColor, int oldColor, Set<String> used) {

        image[sr][sc] = newColor;
        String index = sr+"_"+sc;
        System.out.println(index);
        if (!used.contains(index)) {
            if (sr-1 >= 0 && image[sr-1][sc] == oldColor) {
                floodFill2(image, sr-1, sc, newColor, oldColor, used);
            }
            if (sc-1 >= 0 && image[sr][sc-1] == oldColor) {
                floodFill2(image, sr, sc-1, newColor, oldColor, used);
            }
            if (sr+1 < image.length && image[sr+1][sc] == oldColor) {
                floodFill2(image, sr+1, sc, newColor, oldColor, used);
            }
            if (sc+1 < image[0].length && image[sr][sc+1] == oldColor) {
                floodFill2(image, sr, sc+1, newColor, oldColor, used);
            }
            used.add(index);
        }
    }

}
