
import java.util.*;

public class NumberGuessingGame {
    static ArrayList<Integer> scorePoints = new ArrayList<Integer>();

    public static void main(String[] args) {
        NumberGuessingGame numberGuessingGame = new NumberGuessingGame();
        numberGuessingGame.menuBox(scorePoints);
    }

    public void menuBox(ArrayList<Integer> scorePoints) {
        NumberGuessingGame numberGuessingGame = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("############################");
        System.out.println("Welcome to the number guessing game");
        System.out.println("Select from below number to perform that action");
        System.out.println("1- Play the Game");
        System.out.println("2- Score Board");
        System.out.println("3- Exit the game");
        System.out.println("############################");
        try {
            System.out.print("Enter number for action : ");
            int menuSelected = input.nextInt();
            switch (menuSelected) {
                case 1:
                    System.out.print("\n" + "Please provide the upper bound of the range for game");
                    int numberRange = input.nextInt();
                    int randomNumber = numberGuessingGame.generateRandomNumber(numberRange);
                    numberGuessingGame.numberChecker(randomNumber);
                    break;
                case 2:
                    numberGuessingGame.displayScorePoints();
                    break;
                case 3:
                    System.out.println("\n" + "Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number, please Try again later");
            }
        } catch (InputMismatchException e) {
            System.err.println("\n" + e.getMessage() + "\n");
            menuBox(scorePoints);
        }
    }



    public void displayScorePoints() {
        System.out.println("############################");
        System.out.println("Score Board");
        System.out.println("############################");
        System.out.println("Your fastest tries in the game is: " + "\n");
        Collections.sort(scorePoints);

        for (Integer scores : scorePoints) {
            System.out.println("Your Score is " + scores + " tries");
        }

        System.out.println(" ");
        menuBox(scorePoints);
    }



    public int generateRandomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }


    public void numberChecker(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Type your guess number here: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        scorePoints.add(guess);
        System.out.println(" ");

        menuBox(scorePoints);
    }


}

