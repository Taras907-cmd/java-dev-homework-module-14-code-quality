import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        while (true) {
            printBoard(board);

            playerMove(board);
            if (checkWinner(board, 'X')) {
                printBoard(board);
                System.out.println(" You win!");
                break;
            }
            if (isDraw(board)) {
                printBoard(board);
                System.out.println(" It's a draw!");
                break;
            }
            computerMove(board);
            if (checkWinner(board, 'O')) {
                printBoard(board);
                System.out.println(" Computer wins!");
                break;
            }
            if (isDraw(board)) {
                printBoard(board);
                System.out.println(" It's a draw!");
                break;
            }
        }
    }

    public static void printBoard(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");

    }

    public static void playerMove(char[] board) {
        while (true) {
            System.out.print("Enter position (1-9): ");
            int input = scanner.nextInt();

            if (input < 1 || input > 9) {
                System.out.println("Invalid number!");
                continue;
            }

            if (board[input - 1] == 'X' || board[input - 1] == 'O') {
                System.out.println("Cell already taken!");
                continue;
            }

            board[input - 1] = 'X';
            break;
        }
    }

    public static void computerMove(char[] board) {
        int move;
        do {
            move = random.nextInt(9);
        } while (board[move] == 'X' || board[move] == 'O');

        board[move] = 'O';
        System.out.println("Computer chose position " + (move + 1));
    }

    public static boolean checkWinner(char[] b, char symbol) {
        int[][] winPositions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] pos : winPositions) {
            if (b[pos[0]] == symbol &&
                    b[pos[1]] == symbol &&
                    b[pos[2]] == symbol) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDraw(char[] board) {
        for (char c : board) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }
        return true;
    }
}