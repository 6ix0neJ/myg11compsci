
import java.util.*;
public class tictactoe {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        int player = 0;
        char mark;
        boolean bInvalid;
        int row, col;
        int winner = 0;
        for (int i =0; i < 9; i++) {
            System.out.println("PLAYER " + (player + 1));
            do {
                System.out.print("Enter Your Spot: ");
                String key = sc.nextLine();
                if (key.length() > 1) continue;
                int keynum = Integer.parseInt(key);
                switch (key) {
                    case 1:
                        row = 0;
                        col = 0;
                        break;
                    case 2:
                        row = 0;
                        col = 1;
                        break;
                    case 3:
                        row = 0;
                        col = 2;
                        break;
                    case 4:
                        row = 1;
                        col = 0;
                        break;
                    case 5:
                        row = 1;
                        col = 1;
                        break;
                    case 6:
                        row = 1;
                        col = 2;
                        break;
                    case 7:
                        row = 2;
                        col = 0;
                        break;
                    case 8:
                        row = 2;
                        col = 1;
                        break;
                    case 9:
                        row = 2;
                        col = 2;
                        break;
                    default:
                        bInvalid = true;
                        System.out.println("Invalid intput!");

                }
                System.out.print("row = ");
                row = sc.nextInt();
                System.out.print("col = ");
                col = sc.nextInt();


                if (board[row][col] == ' ') {
                    bInvalid = false;
                }
                else  {
                    bInvalid = true;
                    System.out.println("Spot Taken. Try Again.");
                    }

            } while (bInvalid);

            if (player == 0) mark = 'X';
            else mark = 'O';

            board[row][col] = mark;
            displayBoard(board);
            if(checkwin(board, row, col)) {
                winner = player + 1;
                break;
            }
            player = (player + 1) % 2;
        }
        if (winner != 0) {
            System.out.println("PLAYER " + winner + " WINS!");
        }
        else {
            System.out.println("Cats Game :/");
        }
    }
    public static void displayBoard(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print("[" + matrix[row][col] + "]");
            }
            System.out.println();
        }
    }
    public static boolean checkwin (char[][]board, int row, int col) {
        //check row
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            return true;
        }
        //check col
        if (board[col][0] == board[col][1] && board[col][1] == board[col][2]) {
            return true;
        }
        // check diagonal
        if (row == 0 && col == 0 || row == 2 && col == 2) {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                return true;
            }
        }
        if (row == 2 && col == 0 || row == 0 && col == 2) {
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                return true;
            }
        }
        if (row == 1 && col == 1) {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                return true;
            }
            if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
                return true;
            }
        }

        return false;
    }
}
