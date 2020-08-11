package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: SpiralOrder
 * @Description: 29. 顺时针打印矩阵
 * @Author: huangdh
 * @Date: 2020/8/11 下午9:18
 */
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};

        int row = matrix.length;
        int column = matrix[0].length;
        int max = row * column;

        int[] res = new int[row * column];
        int index = 0;

        int startRow = 0;
        int endRow = row - 1;
        int startColumn = 0;
        int endColumn = column - 1;

        while (startRow <= endRow && startColumn <= endColumn) {
            for (int j = startColumn; j <= endColumn && index != max; j++) {
                res[index++] = matrix[startRow][j];
            }
            for (int i = startRow + 1; i <= endRow - 1 && index != max; i++) {
                res[index++] = matrix[i][endColumn];
            }
            for (int i = endColumn; i >= startColumn && index != max; i--) {
                res[index++] = matrix[endRow][i];
            }
            for (int i = endRow - 1; i >= startRow + 1 && index != max; i--) {
                res[index++] = matrix[i][startColumn];
            }
            startRow = startRow + 1;
            endRow = endRow - 1;
            startColumn = startColumn + 1;
            endColumn = endColumn - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{7},{9},{6}};
        int[] res = new SpiralOrder().spiralOrder(matrix);
        System.out.println(JSON.toJSONString(res));
    }

}
