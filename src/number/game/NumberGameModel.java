package number.game;
import javax.swing.*;
import java.util.Random;

public class NumberGameModel {
    private int targetNumber;
    private int maxAttempts;


    private int currentAttempts;
    private int roundsWon;

    public NumberGameModel(int min, int max, int maxAttempts) {
        this.maxAttempts = maxAttempts;
        generateRandomNumber(min, max);
        currentAttempts = 0;
        roundsWon = 0;
    }

    public void generateRandomNumber(int min, int max) {
        Random rand = new Random();
        targetNumber = rand.nextInt((max - min) + 1) + min;
    }

    public int getTargetNumber() {
        return targetNumber;
    }


    public int getRemainingAttempts() {
        return maxAttempts - currentAttempts;
    }

    public boolean isGameOver() {
        return currentAttempts >= maxAttempts || roundsWon > 0;
    }

    public void incrementAttempts() {
        currentAttempts++;
    }

    public void incrementRoundsWon() {
        roundsWon++;
    }



    public void setCurrentAttempts(int currentAttempts) {
        this.currentAttempts = currentAttempts;
    }


    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }

/*
    public void startNewRound() {
        currentAttempts = 0; // Reset the attempts for a new round
        roundsWon = 0; // Reset the rounds won
        generateRandomNumber(1, 100); // Generate a new random number within the specified range
    }
*/
}

