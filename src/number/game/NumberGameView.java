package number.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGameView implements ActionListener {
    private JFrame frame;
    private JLabel headingLabel;
    private JLabel resultLabel;
    private JLabel attemptsLabel;
    private JTextField inputField;
    private JButton submitButton;
    private NumberGameModel model;
    private NumberGameController controller;

    public NumberGameView(NumberGameModel model) {
        this.model = model;

        frame = new JFrame("Number Game");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        headingLabel = new JLabel("Guess The Number");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 28));
        headingLabel.setBounds(120, 30, 300, 30);
        frame.add(headingLabel);

        resultLabel = new JLabel("Enter a number between 1 to 100.");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel.setForeground(Color.RED);
        resultLabel.setBounds(120, 100, 400, 30);
        frame.add(resultLabel);

        attemptsLabel = new JLabel("Attempts left: " + model.getRemainingAttempts());
        attemptsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        attemptsLabel.setBounds(50, 250, 400, 30);
        frame.add(attemptsLabel);

        inputField = new JTextField();
        inputField.setBounds(100, 150, 300, 30);
        frame.add(inputField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(200, 200, 100, 30);
        frame.add(submitButton);
        submitButton.addActionListener(this);
        frame.setVisible(true);

    }//constructor

    public void setController(NumberGameController controller) {
        this.controller = controller;
    }
@Override
    public void actionPerformed(ActionEvent event){
        controller.handleUserGuess();
    }
    public void updateUI(String message) {
        resultLabel.setText(message);
        inputField.setText("");
        attemptsLabel.setText("Attempts left: " + model.getRemainingAttempts());
    }

    public int getUserGuess() {
        String inputText = inputField.getText();
        if (inputText.isEmpty()) {
            return -1;
        }
        try {
            return Integer.parseInt(inputText);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void displayMessage(String message) {

        int result = JOptionPane.showConfirmDialog(null, message+"\nDo you want to play again?", "Play Again",
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.dispose();

        } else{
            controller.startNewRounds();
        }

      //  JOptionPane.showMessageDialog(frame, message);
    }
}
