import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        Random random = new Random();
        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        int score = 0;
        char playAgain;

        do {
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrect = false;

            System.out.println("\nGuess the number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Correct! You guessed the number.");
                    score++;
                    guessedCorrect = true;
                    break;
                } 
                else if (userGuess > randomNumber) {
                    System.out.println("Too high!");
                } 
                else {
                    System.out.println("Too low!");
                }
            }

            if (!guessedCorrect) {
                System.out.println("You have used all attempts.");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\nGame Over!");
        System.out.println("Your score: " + score);

        scanner.close();
    }
}

