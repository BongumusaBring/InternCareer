import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField textField;
    private String operator;
    private double firstNumber, secondNumber;

    public SimpleCalculator() {
        // Set up
        setTitle("Basic Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Ccomponents
        textField = new JTextField();
        textField.setEditable(false);

        // comma fixed
        JButton commaButton = new JButton(".");
        commaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = textField.getText();
                // current text already contains a decimal point
                if (!currentText.contains(".")) {
                    textField.setText(currentText + ".");
                }
            }
        });


        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new NumberButtonActionListener());
        }

        JButton addButton = createOperationButton("+");
        JButton subtractButton = createOperationButton("-");
        JButton multiplyButton = createOperationButton("*");
        JButton divideButton = createOperationButton("/");
        JButton equalsButton = createEqualsButton();
        JButton clearButton = createClearButton();

        // layout
        setLayout(new GridLayout(5, 2, 05, 05));

        // components
        add(textField);
        add(clearButton);
        add(divideButton);
        add(multiplyButton);
        
        add(numberButtons[7]);
        add(numberButtons[8]);
        add(numberButtons[9]);
        add(subtractButton);

        add(numberButtons[4]);
        add(numberButtons[5]);
        add(numberButtons[6]);
        add(addButton);
        
        add(numberButtons[1]);
        add(numberButtons[2]);
        add(numberButtons[3]);
        add(equalsButton);
        
        add(numberButtons[0]);
        add(commaButton);
   
        // visible
        setVisible(true);
    }

    private JButton createOperationButton(String operation) {
        JButton button = new JButton(operation);
        button.addActionListener(new OperationButtonActionListener());
        return button;
    }

    private JButton createEqualsButton() {
        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondNumber = Double.parseDouble(textField.getText());
                double result = performOperation(firstNumber, secondNumber, operator);
                textField.setText(String.valueOf(result));
                operator = null;
            }
        });
        return equalsButton;
    }

    private JButton createClearButton() {
        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                firstNumber = secondNumber = 0;
                operator = null;
            }
        });
        return clearButton;
    }

    private double performOperation(double num1, double num2, String operation) {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(SimpleCalculator.this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            default:
                return 0;
        }
    }

    private class NumberButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = textField.getText();
            JButton button = (JButton) e.getSource();
            textField.setText(currentText + button.getText());
        }
    }

    private class OperationButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            operator = button.getText();
            firstNumber = Double.parseDouble(textField.getText());
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}
