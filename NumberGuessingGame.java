import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Random random = new Random();
int totalScore = 0;
int rounds = 3; // You can change the number of rounds
System.out.println(" Welcome to the Number Guessing Game!");
System.out.println("You have 5 attempts per round to guess a number between 1 and 100.\n");
for (int round = 1; round <= rounds; round++) {
int numberToGuess = random.nextInt(100) + 1;
int attemptsLeft = 5;
boolean guessedCorrectly = false;
System.out.println("Round " + round + " begins!");
while (attemptsLeft > 0) {
System.out.print("Enter your guess: ");
int userGuess = scanner.nextInt();
attemptsLeft--;
if (userGuess == numberToGuess) {
System.out.println("Correct! You guessed the number.");
int pointsEarned = attemptsLeft + 1; // More points for fewer attempts
totalScore += pointsEarned;
System.out.println("You earned " + pointsEarned + " points.\n");
guessedCorrectly = true;
break;
} 
else if (userGuess < numberToGuess) {
System.out.println(" Too low!");
} 
else {
System.out.println(" Too high!");
}
System.out.println("Attempts left: " + attemptsLeft);
}
if (!guessedCorrectly) {
System.out.println("Out of attempts! The number was: " + numberToGuess + "\n");
}
}
System.out.println(" Game Over! Your total score: " + totalScore);
scanner.close();
}
}