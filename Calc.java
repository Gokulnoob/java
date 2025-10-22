import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Renamed to Calc for better convention
public class Calc extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] buttons;
    private String input = "";
    private double num1, num2, result;
    private char operator;

    public Calc() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField(10);
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

        JPanel panel = new JPanel(new GridLayout(4, 4));
        // Corrected the button labels array syntax
        String[] buttonLabels = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", "=", "/"};
        buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        add(textField, BorderLayout.NORTH);
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();

        if (command.matches("[0-9]")) {
            input += command;
            textField.setText(input);
        } else if (command.matches("[+\\-*/]")) { // Corrected regex to match operators
            if (!input.isEmpty()) {
                num1 = Double.parseDouble(input);
                operator = command.charAt(0);
                input = "";
            }
        } else if (command.equals("=")) {
            if (!input.isEmpty() && num1 != 0) { // Check to prevent error if '=' is pressed first
                num2 = Double.parseDouble(input);
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            textField.setText("Error");
                            input = "";
                            num1 = 0;
                            return;
                        }
                        break;
                }
                textField.setText(String.valueOf(result));
                input = String.valueOf(result); // Set result as input for continuous calculation
                num1 = result; // Update num1 for next operation
            }
        } else if (command.equals("C")) {
            input = "";
            textField.setText("");
            num1 = 0;
            num2 = 0;
            operator = ' ';
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calc());
    }
}