import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean exit = false;
        do {
            System.out.println("Guess the number, The game");
            System.out.println("Instructions: Enter a number between 1 and 100");
            System.out.println("But first, choose the difficulty:");
            System.out.println("1 : Easy (8 attempts)");
            System.out.println("2 : Normal (6 attempts)");
            System.out.println("3 : Hard (4 attempts)");
            System.out.println("4 : Impossible (2 attempts)");
            
            boolean validLevel = false;
            int attempts = 0;
            while (validLevel == false) {
                int level = scanner.nextInt();
        
                switch (level) {
                    case 1:
                        attempts = 8;
                        validLevel = true;
                        break;
                    case 2:
                        attempts = 6;
                        validLevel = true;
                        break;
                    case 3:
                        attempts = 4;
                        validLevel = true;
                        break;
                    case 4:
                        attempts = 2;
                        validLevel = true;
                        break;
                    default:
                        System.out.println("Out of range, please choose a number between 1 and 4");
                        break; 
                }        
            }
        
            Game.guessNumber(attempts);
        
            System.out.println("Do you want to continue?");
            System.out.println("1 - Continue / 0 - Exit");
        
            int exitChoice = scanner.nextInt();
            
            switch (exitChoice) {
                case 1:
                    break;
                case 0:
                    exit = true;
                    System.out.println("Thanks for playing");
                    break;
                default:
                    System.out.println("I'll assume that's a no");
                    exit = true;
                    break;
            }
        } while (!exit);
    }
}

class Game {
    public static void guessNumber(int maxAttempts) {
        Random randomNumbers = new Random();
        Scanner scanner = new Scanner(System.in);
            
        int number = randomNumbers.nextInt(100) + 1;
        int attemptsUsed = 0;
        
        System.out.println("You have " + maxAttempts + " attempts to guess the number");
        boolean exit = false;
        while (!exit) {
            System.out.print("Guess: ");
            int input = scanner.nextInt();
            scanner.nextLine(); 

            attemptsUsed++;

            if (input < 0 || input > 100) {
                System.out.println("Out of range, please enter a number between 1 and 100");
            } else if (number == input) {
                System.out.println("The number was " + number);
                System.out.println("Congratulations, you got it!");
                System.out.println("Attempts used: " + attemptsUsed);
                break;
            } else if (input > number) {
                System.out.println("Nope, it's smaller.");
            } else if (input < number) {
                System.out.println("Nope, it's bigger.");
            }
            
            if (attemptsUsed >= maxAttempts) {
                System.out.println("Game over, you used all your attempts.");
                System.out.println("The correct number was: " + number);
                break;
            }
        }
    }
}
