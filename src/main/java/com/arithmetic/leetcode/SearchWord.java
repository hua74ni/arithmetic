package com.arithmetic.leetcode;

public class SearchWord {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] flag = new boolean[row][column];
        char[] chars = word.toCharArray();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == chars[0]) {
                    flag[i][j] = true;
                    if (searchNext(1, board, flag, chars, i, j)) {
                        return true;
                    }
                    flag[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean searchNext(int index, char[][] board, boolean[][] flag, char[] chars, int row, int column) {
        if (index == chars.length) {
            return true;
        }
        // 上下左右
        if (handlerNext(index, board, flag, chars, row - 1, column)
                || handlerNext(index, board, flag, chars, row + 1, column)
                || handlerNext(index, board, flag, chars, row, column - 1)
                || handlerNext(index, board, flag, chars, row, column + 1)) {
            return true;
        }
        return false;
    }

    private boolean handlerNext(int index, char[][] board, boolean[][] flag, char[] chars, int row, int column) {
        // 边界
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
            return false;
        }
        // 已使用 || 不相同
        if (flag[row][column] || board[row][column] != chars[index]) {
            return false;
        }
        flag[row][column] = true;
        if (searchNext(index + 1, board, flag, chars, row, column)) {
            return true;
        }
        flag[row][column] = false;
        return false;
    }

    public static void main(String[] args) {

        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        System.out.println(new SearchWord().exist(board, word));
    }

}
