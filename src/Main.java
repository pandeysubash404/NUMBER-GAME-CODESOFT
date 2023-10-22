import number.game.NumberGameModel;
public class Main {
    public static void main(String[] args) {
        NumberGameModel model = new NumberGameModel(1,100,10);
        model.generateRandomNumber();
        System.out.println(model.getTargetNumber()+"Hello world!");


    }
}