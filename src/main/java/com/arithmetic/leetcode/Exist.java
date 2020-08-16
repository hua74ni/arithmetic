package com.arithmetic.leetcode;

public class Exist {

    private char[][] board;
    private char[] chars;
    private boolean[][] booleans;
    private int rowMax;
    private int columnMax;

    public boolean exist(char[][] board, String word) {
        rowMax = board.length - 1;
        columnMax = board[0].length - 1;
        this.board = board;
        this.chars = word.toCharArray();
        this.booleans = new boolean[rowMax + 1][columnMax + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    booleans[i][j] = true;
                    if (hasFindString(i, j, 1)) return true;
                    booleans[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean hasFindString(int row, int column, int index) {
        if (index >= chars.length) return true;
        if (findStringAndNext(row + 1, column, index) || findStringAndNext(row, column + 1, index)
                || findStringAndNext(row - 1, column, index) || findStringAndNext(row, column - 1, index)) {
            return true;
        }
        return false;
    }

    private boolean findStringAndNext(int row, int column, int index) {
        if (row < 0 || column < 0 || row > rowMax || column > columnMax) return false;
        if (!booleans[row][column] && board[row][column] == chars[index]) {
            booleans[row][column] = true;
            if (hasFindString(row, column, index + 1)) return true;
            booleans[row][column] = false;
        }
        return false;
    }


    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

//        char[][] board = {{'a', 'B'}, {'c', 'd'}};
//        String word = "abcd";

        System.out.println(new Exist().exist(board, word));

    }

}
