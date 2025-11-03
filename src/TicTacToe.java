/*
Tic Tac Toe Outline:
1. Set Row & Column max values to 3
2. Populate Rows & Columns with []
3. Set variable declarations
4. Run Do command to clear values, welcome, and display board
5. Run While command to gather player X prompt
6. Input invalid move declaration
7. Run If for valid move to determine win or tie (show invalid input for wrong inputs)
8. Take second players input and display on board
9. Display move count and moves left
10. Close Do with Play Again prompt
11. Helper methods for main code reference
 */

import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String player = "X";
        boolean playAgain = true;
        int moveCount = 0;
        int row = 0;
        int column = 0;

        do {
            System.out.println("Welcome to Tic Tac Toe!");
            clearBoard();
            display();

            while(playAgain) {
                row = SafeInput.getRangeInt(scanner, "Player " + player + ", enter row", 1, 3) - 1;
                column = SafeInput.getRangeInt(scanner, "Player " + player + ", enter column", 1, 3) - 1;

                while (!isValidMove(row, column)) {
                    System.out.println("Invalid move. Please try again.");
                    row = SafeInput.getRangeInt(scanner, "Player " + player + ", enter row", 1, 3) - 1;
                    column = SafeInput.getRangeInt(scanner, "Player " + player + ", enter column", 1, 3) - 1;
                }

                if (isValidMove(row, column)) {
                    board[row][column] = player;
                    if (isWin(player)) {
                        display();
                        System.out.println("Player " + player + " wins!");
                        break;
                    } else if (isTie()) {
                        display();
                        System.out.println("Tie!");
                        break;
                    }
                    // inputs for player O
                    player = (player.equals("X")) ? "O" : "X";
                    display();
                    moveCount++;
                } else {
                    display();
                    System.out.println("Invalid move. Please Try again.");
                }
                System.out.println(moveCount + " moves complete!");
                System.out.println(9-moveCount + " possible moves remaining!");
            }
            playAgain = SafeInput.getYNConfirm(scanner, "Do you want to play again?");
            moveCount = 0;
            player = "X";
        } while (playAgain);
        scanner.close();
    }

    //Helper method
    private static void clearBoard() {
        for (int r = 0; r < ROW; r++)
            for (int c = 0; c < COL; c++)
                board[r][c] = " ";
    }

    private static void display() {
        System.out.println("Board:");
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                System.out.print("[" + board[r][c] + "]");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int r = 0; r < ROW; r++) {
            if (board[r][0].equals(player) &&
                    board[r][1].equals(player) &&
                    board[r][2].equals(player)) return true;
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int c = 0; c < COL; c++) {
            if (board[0][c].equals(player) &&
                    board[1][c].equals(player) &&
                    board[2][c].equals(player)) return true;
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player)) ||
                (board[0][2].equals(player) &&
                        board[1][1].equals(player) &&
                        board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int r = 0; r < ROW; r++)
            for (int c = 0; c < COL; c++)
                if (board[r][c].equals(" ")) return false;
        return true;
    }
}