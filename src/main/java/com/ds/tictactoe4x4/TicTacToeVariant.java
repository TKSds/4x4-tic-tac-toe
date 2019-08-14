package com.ds.tictactoe4x4;

/**
 * 4x4 TicTacToe Variant
 */
public class TicTacToeVariant {

    private char lastPlayer = '\0';

    private static final int SIZE = 4;

    private Character[][] board = {
            {'\0', '\0', '\0', '\0'},
            {'\0', '\0', '\0', '\0'},
            {'\0', '\0', '\0', '\0'},
            {'\0', '\0', '\0', '\0'}
    };


    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y);

        if (isWin()) {
            return lastPlayer + " is the winner";
        }
        return "No winner";
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 4) {
            throw new RuntimeException("Piece is outside the axis");
        }
    }

    private void setBox(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x - 1][y - 1] = 'X';
        }
    }

    private boolean isWin() {
        int playerTotal = lastPlayer * SIZE;
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] + board[1][i] + board[2][i] + board[3][i] == playerTotal) {
                return true;
            } else if (board[i][0] + board[i][1] + board[i][2] + board[i][3] == playerTotal) {
                return  true;
            }
        }
        return false;
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}
