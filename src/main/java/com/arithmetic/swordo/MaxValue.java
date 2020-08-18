package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: MaxValue
 * @Description: 47. 礼物的最大价值
 * @Author: huangdh
 * @Date: 2020/8/18 上午10:47
 */
public class MaxValue {

    private int[][] grid;

    public int maxValue(int[][] grid) {
        this.grid = grid;
        int row = grid.length - 1;
        int column = grid[0].length - 1;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                int top = 0;
                int left = 0;
                if (i - 1 >= 0) {
                    top = grid[i - 1][j];
                }
                if (j - 1 >= 0) {
                    left = grid[i][j - 1];
                }
                grid[i][j] = grid[i][j] + Math.max(top, left);
            }
        }

        return grid[row][column];
    }

    private int recusion(int row, int column) {
        if (row < 0 || column < 0) return 0;
        int maxGift = Math.max(recusion(row - 1, column), recusion(row, column - 1)) + grid[row][column];
        return maxGift;
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid = new int[][]{{3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3}, {0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2}, {8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9}, {1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7}, {8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8}, {4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9}, {6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1}, {8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3}, {9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3}, {0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8}, {4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3}, {2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3}, {0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3}, {0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5}, {6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2}, {7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0}, {3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0}, {5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}};
        System.out.println(new MaxValue().maxValue(grid));
    }

}
