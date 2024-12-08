import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess the Number, The Game");
        System.out.println("Instructions: Put a number between 1 and 100");
        System.out.println("But first, choose the difficulty level:");
        System.out.println("1 : Easy (8 attempts)");
        System.out.println("2 : Medium (6 attempts)");
        System.out.println("3 : Hard (4 attempts)");
        System.out.println("4 : Impossible (2 attempts)");

        int level = scanner.nextInt();
        int attempts = 0;
        
        switch (level) {
            case 1:
                attempts = 8;
                break;
            case 2:
                attempts = 6;
                break;
            case 3:
                attempts = 4;
                break;
            case 4:
                attempts = 2;
                break;
            default:
                System.out.println("Out of range, choose a number between 1 and 4");
                return; 
        }
        
        Game.guessNumber(attempts);
    }
}

class Game {
    public static void guessNumber(int maxAttempts) {
        Random randomNumbers = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        int number = randomNumbers.nextInt(100) + 1;
        int attemptsUsed = 0;

        System.out.println("You have " + maxAttempts + " attempts to guess the number!");

        while (!exit) {
            System.out.print("Enter your guess: ");
            int input = scanner.nextInt();
            scanner.nextLine(); 

            attemptsUsed++;

            if (input < 0 || input > 100) {
                System.out.println("Out of range, please put a valid number between 0 and 100");
            } else if (number == input) {
                System.out.println("The number was " + number);
                System.out.println("Congratulations, you got it!");
                System.out.println("Attempts used: " + attemptsUsed);
                break;
            } else if (input > number) {
                System.out.println("Nope, it's smaller.");
            } else {
                System.out.println("Nope, it's bigger.");
            }
            
            if (attemptsUsed >= maxAttempts) {
                System.out.println("Game over! You've used all your attempts.");
                System.out.println("The correct number was: " + number);
                break;
            }
        }

        System.out.println("Thanks for playing! Goodbye!");
    }
}