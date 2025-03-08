import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess a number between 1 and 100. You have 10 attempts.");

            for (attempts = 1; attempts <= 10; attempts++) {
                System.out.print("Attempt " + attempts + " Enter your guess: ");
                int userGuess;

                
                while (!scan.hasNextInt()) {
                    System.out.println("Oops Invalid input! Please enter a number.");
                    scan.next(); // Clear invalid input
                }
                userGuess = scan.nextInt();

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue; // Skip this attempt
                }

                if (userGuess == randomNumber) {
                    System.out.println("Voila! Your guess is correct! Congratulations!!!");
                    System.out.println("It took you " + attempts + " tries to guess the right number.");
                    System.out.println("Your score is " + (10 - attempts) + " out of 10!");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Nope, guess higher.");
                } else {
                    System.out.println("Nope, guess lower.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Oops, you've used all 10 attempts. The correct number was " + randomNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scan.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
                System.out.println("Thank you for playing! Have a nice day!");
            }
        }

        scan.close();
    }
}