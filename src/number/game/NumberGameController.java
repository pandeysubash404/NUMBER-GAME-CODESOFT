package number.game;
public class NumberGameController {
    private NumberGameModel model;
    private NumberGameView view;

    public NumberGameController(NumberGameModel model, NumberGameView view) {
        this.model = model;
        this.view = view;
    }

    public void startNewRounds() {
      //  model.setRoundsWon(0);
        model.setCurrentAttempts(0);
        model.generateRandomNumber();
        view.updateUI("Enter a number between 1 to 100.");
    }

    public void handleUserGuess() {

        if (model.isGameOver()) {
            view.displayMessage("Game Over! The correct number was " + model.getTargetNumber());
            return;
        }

        int userGuess = view.getUserGuess();
        System.out.println(userGuess+" userGuess");
        if (userGuess == -1) {
            view.updateUI("Invalid input. Please enter a number.");
        }else if (userGuess>model.getMax() || userGuess< model.getMin()) {
            view.updateUI("Invalid input. Out of the range.");
        }else {
            model.incrementAttempts();
            if (userGuess == model.getTargetNumber()) {
                view.displayMessage("Congratulations! You guessed the correct number : "+ model.getTargetNumber());
            } else if (userGuess < model.getTargetNumber()) {
                view.updateUI("Your guess is too low. Try again.");
            } else {
                view.updateUI("Your guess is too high. Try again.");
            }
        }
    }



}

