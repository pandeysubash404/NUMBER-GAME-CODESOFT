package number.game;
import java.util.Random;

public class NumberGameModel {
    private int targetNumber;
    private int maxAttempts;
    private int maxRange;

    private int minRange;
    private int currentAttempts;

    public NumberGameModel(int minRange, int maxRange, int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.maxRange=maxRange;
        this.minRange=minRange;
        generateRandomNumber();
        currentAttempts = 0;
    }

    public void generateRandomNumber() {
        Random rand = new Random();
        targetNumber = rand.nextInt((this.maxRange - this.minRange) + 1) + this.minRange;
    }

    public int getTargetNumber() {
        return targetNumber;
    }


    public int getRemainingAttempts() {
        return maxAttempts - currentAttempts;
    }

    public boolean isGameOver() {
        return currentAttempts >= maxAttempts-1;
    }

    public void incrementAttempts() {
        currentAttempts++;
    }

    public void setCurrentAttempts(int currentAttempts) {
        this.currentAttempts = currentAttempts;
    }

    public int getMax() {
        return maxRange;
    }

    public int getMin() {
        return minRange;
    }

}

