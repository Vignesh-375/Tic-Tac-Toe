import java.util.Scanner;

public class Main {
    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        int moves = 0;

        while (true) {
            printBoard();
            System.out.print("Player " + currentPlayer + ", enter position (1-9): ");
            int pos = sc.nextInt();

            if (!placeMark(pos, currentPlayer)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            moves++;

            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println(" Player " + currentPlayer + " wins!");
                break;
            }

            if (moves == 9) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Switch players
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Print the game board
    public static void printBoard() {
        System.out.println("\nCurrent Board:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(" " + cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Place the mark if the position is valid
    public static boolean placeMark(int pos, char player) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == (char)(pos + '0')) {
                    board[i][j] = player;
                    return true;
                }
            }
        }
        return false;
    }

    // Check if the current player wins
    public static boolean checkWin(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) return true;

            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player) return true;
        }

        // Diagonals
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) return true;

        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) return true;

        return false;
    }
}
