package model;

import processing.core.PApplet;

public class Modeltest extends PApplet {
    public static void main(String[] args) {
        PApplet.main(Modeltest.class);
    }
    int[][] board = new int[7][6];
    int currentPlayer = 1;
    int winner = 0;

    public void settings() {
        size(700, 600);
    }

    public void setup() {
        // Initialize the board with all cells set to 0 (empty)
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void draw() {
        background(255);
        // Draw the board
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] == 0) {
                    fill(255);
                } else if (board[i][j] == 1) {
                    fill(255, 0, 0);
                } else {
                    fill(0, 255, 0);
                }
                rect(i * 100, j * 100, 100, 100);
            }
        }
        // Check for a winner
        if (checkForWinner()) {
            if (winner == 1) {
                fill(255, 0, 0);
                text("Player 1 wins!", width / 2, height / 2);
            } else if (winner == -1) {
                fill(0, 255, 0);
                text("Player 2 wins!", width / 2, height / 2);
            }
        }
    }

    public void mouseClicked() {
        if (winner == 0) {
            int column = mouseX / 100;
            if (column >= 0 && column < 7) {
                // Find the first empty cell in the column
                int row = 5;
                while (row >= 0 && board[column][row] != 0) {
                    row--;
                }
                if (row >= 0) {
                    board[column][row] = currentPlayer;
                    currentPlayer = -currentPlayer;
                }
            }
        }
    }

    public boolean checkForWinner() {
        // Check for horizontal lines
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2] && board[i][j + 2] == board[i][j + 3] && board[i][j] != 0) {
                    winner = board[i][j];
                    return true;
                }
            }
        }
        // Check for vertical lines
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] == board[i + 1][j] && board[i + 1][j] == board[i + 2][j] && board[i + 2][j] == board[i + 3][j] && board[i][j] != 0) {
                    winner = board[i][j];
                    return true;
                }
            }
        }
        // Check for diagonal lines
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == board[i + 1][j + 1] && board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3] && board[i][j] != 0) {
                    winner = board[i][j];
                    return true;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j < 6; j++) {
                if (board[i][j] == board[i + 1][j - 1] && board[i + 1][j - 1] == board[i + 2][j - 2] && board[i + 2][j - 2] == board[i + 3][j - 3] && board[i][j] != 0) {
                    winner = board[i][j];
                    return true;
                }
            }
        }

        return false;
    }
}

