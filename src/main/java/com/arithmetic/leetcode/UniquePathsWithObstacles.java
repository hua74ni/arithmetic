package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: UniquePathsWithObstacles
 * @Description: 63. 不同路径 II
 * @Author: huangdh
 * @Date: 2020/9/25 上午10:29
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] path = new int[row][column];
        for (int i = 0; i < column; i++) {
            if (obstacleGrid[0][i] == 1) break;
            path[0][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) break;
            path[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                int top = 0;
                int left = 0;
                if (obstacleGrid[i - 1][j] == 0) {
                    top = path[i - 1][j];
                }
                if (obstacleGrid[i][j - 1] == 0) {
                    left = path[i][j - 1];
                }
                path[i][j] = top + left;
            }
        }
        return path[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 0}, {1, 1}, {0, 0}};
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(obstacleGrid));
    }

}
