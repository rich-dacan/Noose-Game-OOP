package br.com.noose.fatec;
import java.util.Scanner;

public class Noose {
    private String word;
    private StringBuilder hiddenWord;
    private int remainingAttempts;
    private boolean isFirstRound = true;

    public Noose(String word, int attempts) {
        this.word = word.toUpperCase();
        this.remainingAttempts = attempts;
        this.hiddenWord = new StringBuilder(word.replaceAll(".", "_"));
    }

    private void designNoose() {
        switch (remainingAttempts) {
            case 6:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 5:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |       |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 4:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |       |");
                System.out.println(" |       |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 3:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |      \\|");
                System.out.println(" |       |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 2:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |      \\|/");
                System.out.println(" |       |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 1:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |      \\|/");
                System.out.println(" |       |");
                System.out.println(" |      /");
                System.out.println("_|___");
                break;
            case 0:
                System.out.println("  _______");
                System.out.println(" |/      |");
                System.out.println(" |      ( )");
                System.out.println(" |      \\|/");
                System.out.println(" |       |");
                System.out.println(" |      / \\");
                System.out.println("_|___");
                break;
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (remainingAttempts > 0 && hiddenWord.indexOf("_") != -1) {
            renderInterface();

            char letter = getUserInput(scanner);

            boolean right = playRound(letter);

            if (!right) {
                remainingAttempts--;
                designNoose();
            }
        }
        scanner.close();

        if (remainingAttempts > 0) {
            System.out.println("\n-------------------- You Win! ------------------------------");
            System.out.println("\nCongratulations! The word has: " + word);
        } else {
            System.out.println("\n-------------------- You Lost! ------------------------------");
            System.out.println("\nYou lost! The word has: " + word);
        }
    }

    public void renderInterface() {
        if (isFirstRound) {
            System.out.println("--------------------------------------------------");
            System.out.println("---------- Welcome to the Noose Game! ------------");
            System.out.println("--------------------------------------------------");
            System.out.println("Test your luck and win money! \n" +
                                    "Get the word right, letter by letter, before you're hanged!\n" +
                                    "Be careful, you only have 5 chances....");
            System.out.println("--------------------------------------------------");
            System.out.println("\nLucky Word: " + hiddenWord.toString() + "\n");
            System.out.println("--------------------------------------------------");
            System.out.println("Attempts remaining: " + remainingAttempts + "\n");
            System.out.print("Which letter are you betting on?: ");

            isFirstRound = false;
        } else {
            System.out.println("\nLucky Word: " + hiddenWord.toString() + "\n");
            System.out.println("--------------------------------------------------");
            System.out.println("Attempts remaining: " + remainingAttempts + "\n");
            System.out.print("Which letter are you betting on?: ");
        }
    }

    public char getUserInput(Scanner scanner) {
        String charInput;

        do {
            charInput = scanner.nextLine().toUpperCase();
            if (charInput.length() != 1) {
                System.out.println("Please type only one letter...");
            }
        } while (charInput.length() != 1);

        return charInput.charAt(0);
    }

    public boolean playRound(char letter) {
        boolean right = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                hiddenWord.setCharAt(i, letter);
                right = true;
            }
        }

        if (!right) {
            System.out.println("\nYou typed '" + letter + "' but the word doesn't have this letter.");
            System.out.println("\nSorry, try again!");
        }

        if (right) {
            System.out.println("\nCongratulations! The word has the letter '" + letter + "'.");
        }

        return right;
    }
}
