package number.game;

public class NumberGameMain {
    public static void main(String[] args) {

        //NumberGameModel(int minRange, int maxRange, int maxAttempts) {}
        NumberGameModel model = new NumberGameModel(1, 100, 10);
        NumberGameView view = new NumberGameView(model);
        NumberGameController controller = new NumberGameController(model, view);

        // Set the controller in the view
        view.setController(controller);

    }
}


