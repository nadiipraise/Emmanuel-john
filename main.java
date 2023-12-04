import java.util.Scanner;
import java.util.Random;
//To launch or start the game
public class LaunchGame {

    private static Random random = new Random();
    private static boolean[] usedQuestions;
//varaible to show the lifelines avaliable to the users
    private static final int LIFELINES_AVAILABLE_EASY = 3;
    private static final int LIFELINES_AVAILABLE_HARD = 3;
    private static final int LIFELINES_PER_ROUND_HARD = 3;

    public static void main(String[] args) {
        displayLaunchScreen();
    }
//class to launch and tell the user about the game
    private static void displayLaunchScreen() {
        System.out.println("Welcome to Who Wants to Be a Millionaire!");
        System.out.println("1. Start the game");
        System.out.println("2. View the rules of the game");
        System.out.println("3. Exit the game");
        System.out.println("Enter your choice (1, 2, or 3): ");

        Scanner scanner = new Scanner(System.in);

        try {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    displayRules();
                    break;
                case 3:
                    System.out.println("Thanks for playing! Goodbye.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
            displayLaunchScreen();
        }
    }
//this class display the game rules to the user
    private static void displayRules() {
        System.out.println("Game Rules:");
        System.out.println("1. Answer questions to win.");
        System.out.println("2. Choose the correct answer (A, B, C, D).");
        System.out.println("3. Incorrect answers end the game.");
        System.out.println("4. Goal: answer all questions correctly and win!");
        System.out.println("Press 0 to go back to the main menu.");

        Scanner scanner = new Scanner(System.in);

        try {
            int backChoice = scanner.nextInt();

            if (backChoice == 0) {
                displayLaunchScreen();
            } else {
                System.out.println("Invalid choice. Returning to the main menu.");
                displayLaunchScreen();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Returning to the main menu.");
            displayLaunchScreen();
        }
    }
//this class starts the game
    private static void startGame() {
        System.out.println("Starting the game...");
        chooseDifficulty();
    }
//this enables the user to choose the difficulty of the game
    private static void chooseDifficulty() {
        Scanner scanner = new Scanner(System.in);
        int difficultyChoice;
        do {
            System.out.println("Choose your difficulty:");
            System.out.println("4. Easy");
            System.out.println("5. Hard");
            System.out.println("Enter your choice (4 or 5) ");

            try {
                difficultyChoice = scanner.nextInt();

                switch (difficultyChoice) {
                    case 4:
                        startEasyGame();
                        break;
                    case 5:
                        startHardGame();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 4 or 5.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                difficultyChoice = -1; // Set an invalid value to continue the loop
            }
        } while (difficultyChoice != 4 && difficultyChoice != 5);
    }
//this starts the easy mode for the users
    private static void startEasyGame() {
        System.out.println("Starting the Easy game...");

        // Array to store questions on sports, presidents, and history for easy difficulty
        String[] questions = {
                "Which sport is played with a shuttlecock?\nA. Tennis\nB. Badminton\nC. Soccer\nD. Golf",
                "Who was the first president of the United States?\nA. Thomas Jefferson\nB. George Washington\nC. Abraham Lincoln\nD. John Adams",
                "In which year did World War II end?\nA. 1945\nB. 1939\nC. 1918\nD. 1941",
                "Who won the FIFA World Cup in 2018?\nA. Brazil\nB. Germany\nC. France\nD. Italy",
                "Who is known as the 'Father of the Nation' in India?\nA. Mahatma Gandhi\nB. Jawaharlal Nehru\nC. Subhash Chandra Bose\nD. Sardar Patel",
                "Which country hosted the 2016 Summer Olympics?\nA. China\nB. Brazil\nC. United States\nD. Russia",
                "Who wrote the 'Declaration of Independence'?\nA. Thomas Jefferson\nB. Benjamin Franklin\nC. John Adams\nD. George Washington",
                "Which ancient civilization built the pyramids?\nA. Greek\nB. Roman\nC. Egyptian\nD. Mesopotamian",
                "Who was the 16th president of the United States?\nA. John F. Kennedy\nB. Abraham Lincoln\nC. Franklin D. Roosevelt\nD. George Washington"
        };

        // Array to store correct answers
        String[] correctAnswers = {"B", "B", "A", "C", "A", "B", "A", "C", "B"};

        // Display and process questions
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);

            Scanner userScanner = new Scanner(System.in);

            try {
                String userAnswer = userScanner.next().toUpperCase();

                if (userAnswer.equals(correctAnswers[i])) {
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Incorrect! Game Over\n");
                    displayLaunchScreen();
                    return; // Exit the method to prevent further questions after a wrong answer
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Game Over\n");
                displayLaunchScreen();
                return; // Exit the method to prevent further questions after invalid input
            }
        }

        // If all questions are answered correctly
        System.out.println("Congratulations! You've won the Easy game!");
        displayLaunchScreen();
    }
//This class starts the hard game section for the user
    private static void startHardGame() {
        System.out.println("Starting the Hard game...");

        // Array to store difficult questions on sports, presidents, and history for hard difficulty
        String[] hardQuestions = {
                "Which country won the most Olympic gold medals in history?\nA. United States\nB. China\nC. Soviet Union\nD. Germany",
                "Who was the longest-serving president of the United States?\nA. Franklin D. Roosevelt\nB. Thomas Jefferson\nC. John F. Kennedy\nD. Ronald Reagan",
                "In which century did the Renaissance begin?\nA. 14th\nB. 15th\nC. 16th\nD. 17th",
                "Who wrote 'The Prince'?\nA. Niccolò Machiavelli\nB. Thomas Hobbes\nC. John Locke\nD. Voltaire",
                "Which team won the first FIFA World Cup in 1930?\nA. Brazil\nB. Uruguay\nC. Italy\nD. Germany",
                "Who was the first woman to win a Nobel Prize?\nA. Marie Curie\nB. Mother Teresa\nC. Rosalind Franklin\nD. Amelia Earhart",
                "Which battle is considered the turning point in the American Civil War?\nA. Battle of Gettysburg\nB. Battle of Antietam\nC. Battle of Bull Run\nD. Battle of Shiloh",
                "What is the capital of Australia?\nA. Sydney\nB. Canberra\nC. Melbourne\nD. Brisbane",
                "Who wrote 'To Kill a Mockingbird'?\nA. Harper Lee\nB. J.K. Rowling\nC. Ernest Hemingway\nD. F. Scott Fitzgerald",
                "What is the largest mammal in the world?\nA. Elephant\nB. Blue Whale\nC. Giraffe\nD. Polar Bear"
        };

        // Array to store correct answers for hard difficulty
        String[] hardCorrectAnswers = {"C", "A", "B", "A", "B", "A", "A", "B", "A", "B"};

        // Display and process hard questions
        for (int i = 0; i < hardQuestions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + hardQuestions[i]);

            Scanner userScanner = new Scanner(System.in);

            try {
                String userAnswer = userScanner.next().toUpperCase();

                if (userAnswer.equals(hardCorrectAnswers[i])) {
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Incorrect! Game Over\n");
                    displayLaunchScreen();
                    return; // Exit the method to prevent further questions after a wrong answer
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Game Over\n");
                displayLaunchScreen();
                return; // Exit the method to prevent further questions after invalid input
            }
        }

        // If all hard questions are answered correctly
        System.out.println("Congratulations! You've won the Hard game!");
        displayLaunchScreen();
    }

    // ... (add methods for handling lifelines, displaying questions, and other necessary functions)

    private static int getRandomUnusedIndex(int max) {
        return random.nextInt(max);
    }
//this class displays the various lifelines the users have
    private static void displayLifelines(boolean[] usedLifelines) {
    System.out.println("Available Lifelines:");
    System.out.println("1. 50/50");
    System.out.println("2. Ask the Audience");
    System.out.println("3. Phone a Friend");
    System.out.println("4. Skip Lifelines");

    // Display which lifelines have already been used
    for (int i = 0; i < usedLifelines.length; i++) {
        if (usedLifelines[i]) {
            System.out.println("Lifeline " + (i + 1) + ": Used");
        }
    }
}

    private static int getLifelineChoice() {
    Scanner scanner = new Scanner(System.in);
    int lifelineChoice = 0;

    try {
        System.out.println("Choose a lifeline (1-4): ");
        lifelineChoice = scanner.nextInt();
    } catch (Exception e) {
        System.out.println("Invalid input. Defaulting to no lifeline.");
    }

    return lifelineChoice;
}
//this implments the logic of the fifyfifty life line
    private static void fiftyFifty(String correctAnswer) {
    System.out.println("Using 50/50 lifeline...");
    System.out.println("Eliminating two incorrect options...");

    // Logic to eliminate two incorrect options
    char[] options = {'A', 'B', 'C', 'D'};
    for (char option : options) {
        if (option != correctAnswer.charAt(0)) {
            System.out.println("Eliminated option " + option);
        }
    }
}
//the class to ask the audience
    private static void askTheAudience(String correctAnswer) {
    System.out.println("Using Ask the Audience lifeline...");
    
    // Placeholder logic for audience response
    int[] audienceVotes = {25, 20, 30, 25}; // Percentage distribution for A, B, C, D

    System.out.println("Audience Response:");
    System.out.println("A: " + audienceVotes[0] + "%");
    System.out.println("B: " + audienceVotes[1] + "%");
    System.out.println("C: " + audienceVotes[2] + "%");
    System.out.println("D: " + audienceVotes[3] + "%");
}
//the class to implemnet phone a friend logic
private static void phoneAFriend(String correctAnswer) {
    System.out.println("Using Phone a Friend lifeline...");

    // Simulate friend's response
    boolean friendKnowsAnswer = random.nextBoolean();

    if (friendKnowsAnswer) {
        char friendResponse = correctAnswer.charAt(0);
        System.out.println("Friend's Response: " + friendResponse);
    } else {
        System.out.println("Friend's Response: I don't know.");
    }
}   
}

