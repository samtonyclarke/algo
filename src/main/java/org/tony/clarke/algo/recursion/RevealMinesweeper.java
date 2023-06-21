package org.tony.clarke.algo.recursion;

import java.util.HashSet;
import java.util.Set;

public class RevealMinesweeper {

    public static void main(String args[]) {
        RevealMinesweeper revealMinesweeper = new RevealMinesweeper();
        String board[][] = {
                {"H", "M"},
                {"H", "H"},
        };

        String[][] strings = revealMinesweeper.revealMinesweeper(board, 1, 1);
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public String[][] revealMinesweeper(String[][] board, int row, int column) {
        if (board[row][column].equals("M")) {
            board[row][column] = "X";
            return board;
        }
        return revealMinesweeper(board, row, column, new HashSet<>());
    }

    public String[][] revealMinesweeper(String[][] board, int row, int column, Set<String> visiting) {

        if (row < 0 || column < 0 || row > board.length - 1 || column > board[0].length - 1) {
            return board;
        }

        if (visiting.contains("" + row + column)) {
            return board;
        }
        visiting.add("" + row + column);
        if (!board[row][column].equals("M")) {
            int i = adjacentMines(board, row, column);
            if (i >0) {
                board[row][column] = "" + i;
                return board;
            } else {
                board[row][column] = "" + i;
            }
        }

        // then visit around the clock
        revealMinesweeper(board, row - 1, column, visiting);
        revealMinesweeper(board, row - 1, column + 1, visiting);
        revealMinesweeper(board, row, column + 1, visiting);
        revealMinesweeper(board, row + 1, column + 1, visiting);
        revealMinesweeper(board, row + 1, column, visiting);
        revealMinesweeper(board, row + 1, column - 1, visiting);
        revealMinesweeper(board, row, column - 1, visiting);
        revealMinesweeper(board, row - 1, column - 1, visiting);
        return board;
    }

    private int adjacentMines(String[][] board, int row, int column) {
        int adjacentMines = 0;
        if (isMine(board, row - 1, column)) {
            adjacentMines++;
        }
        if (isMine(board, row - 1, column + 1)) {
            adjacentMines++;
        }
        if (isMine(board, row, column + 1)) {
            adjacentMines++;
        }
        if (isMine(board, row + 1, column + 1)) {
            adjacentMines++;
        }
        if (isMine(board, row + 1, column)) {
            adjacentMines++;
        }
        if (isMine(board, row + 1, column - 1)) {
            adjacentMines++;
        }
        if (isMine(board, row, column - 1)) {
            adjacentMines++;
        }
        if (isMine(board, row - 1, column - 1)) {
            adjacentMines++;
        }
        return adjacentMines;
    }

    private boolean isMine(String[][] board, int row, int column) {
        if (row < 0 || column < 0 || row > board.length - 1 || column > board[0].length - 1) {
            return false;
        }
        if (board[row][column].equals("M")) {
            return true;
        }
        return false;
    }


}
