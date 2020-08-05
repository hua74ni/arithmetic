package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: FindNumberIn2DArray
 * @Description: 04. 二维数组中的查找
 * @Author: huangdh
 * @Date: 2020/8/5 上午10:53
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int column = matrix[0].length;

        if (startFindColumn(matrix, target, row, column)) {
            return true;
        }
        return false;
    }

    private boolean startFindColumn(int[][] matrix, int target, int row, int column) {
        int findMaxRow = 0;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == target) {
                return true;
            }
            findMaxRow = i;
            if (matrix[i][0] > target) {
                break;
            }
        }

        for (int i = findMaxRow; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] < target) {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };

        int[][] matrix = {
                {1, 3, 5, 7, 9},
                {2, 4, 6, 8, 10},
                {11, 13, 15, 17, 19},
                {12, 14, 16, 18, 20},
                {21, 22, 23, 24, 25}};

        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(matrix, 13));
    }

}
