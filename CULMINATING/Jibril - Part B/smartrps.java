import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class smartrps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Game state variables
        int playerWins = 0;
        int computerWins = 0;
        int rounds = 0;
        String firstPlayerMove = "";
        boolean isFirstRound = true;

        System.out.println("Welcome to Smart Rock-Paper-Scissors!");
        System.out.println("Best 3 out of 5 wins the game!");
        System.out.println("Ties don't count toward the total rounds.\n");

        // Game loop - continues until someone wins 3 rounds
        while (playerWins < 3 && computerWins < 3) {
            // Get player input
            System.out.print("Enter your choice (ROCK, PAPER, or SCISSORS): ");
            String playerChoice = scanner.nextLine().trim().toUpperCase();

            // Validate input
            if (!playerChoice.equals("ROCK") && !playerChoice.equals("PAPER") && !playerChoice.equals("SCISSORS")) {
                System.out.println("Invalid choice! Please enter ROCK, PAPER, or SCISSORS.\n");
                continue;
            }

            // Store first move for prediction
            if (isFirstRound) {
                firstPlayerMove = playerChoice;
                isFirstRound = false;
            }

            // Computer makes its choice
            String computerChoice;
            if (rounds == 0) {
                // First round: random choice
                int randomChoice = random.nextInt(3);
                if (randomChoice == 0) {
                    computerChoice = "ROCK";
                } else if (randomChoice == 1) {
                    computerChoice = "PAPER";
                } else {
                    computerChoice = "SCISSORS";
                }
                System.out.println("(Computer is choosing randomly for the first round)");
            } else {
                // Subsequent rounds: predict player will choose from moves they haven't played yet
                ArrayList<String> unplayedMoves = new ArrayList<>();
                if (!firstPlayerMove.equals("ROCK")) {
                    unplayedMoves.add("ROCK");
                }
                if (!firstPlayerMove.equals("PAPER")) {
                    unplayedMoves.add("PAPER");
                }
                if (!firstPlayerMove.equals("SCISSORS")) {
                    unplayedMoves.add("SCISSORS");
                }

                // Randomly select from unplayed moves
                String predictedMove = unplayedMoves.get(random.nextInt(unplayedMoves.size()));
                System.out.println("(Computer predicts you'll play: " + predictedMove + ")");

                // Choose the counter to the predicted move
                if (predictedMove.equals("ROCK")) {
                    computerChoice = "PAPER";  // Paper beats Rock
                } else if (predictedMove.equals("PAPER")) {
                    computerChoice = "SCISSORS";  // Scissors beats Paper
                } else {
                    computerChoice = "ROCK";  // Rock beats Scissors
                }
            }

            System.out.println("You chose: " + playerChoice);
            System.out.println("Computer chose: " + computerChoice);

            // Determine winner
            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a TIE! This round doesn't count.\n");
                // Don't increment rounds counter for ties
            } else if (
                (playerChoice.equals("ROCK") && computerChoice.equals("SCISSORS")) ||
                (playerChoice.equals("PAPER") && computerChoice.equals("ROCK")) ||
                (playerChoice.equals("SCISSORS") && computerChoice.equals("PAPER"))
            ) {
                System.out.println("You WIN this round!\n");
                playerWins++;
                rounds++;
            } else {
                System.out.println("Computer WINS this round!\n");
                computerWins++;
                rounds++;
            }

            // Display current score
            System.out.println("Score - You: " + playerWins + " | Computer: " + computerWins);
            System.out.println("Rounds played: " + rounds + "\n");
        }

        // Game over - announce winner
        System.out.println("=================================");
        System.out.println("        GAME OVER!");
        System.out.println("=================================");
        if (playerWins == 3) {
            System.out.println("Congratulations! You won the game!");
        } else {
            System.out.println("Computer wins the game! Better luck next time!");
        }
        System.out.println("Final Score - You: " + playerWins + " | Computer: " + computerWins);

        scanner.close();
    }
}
