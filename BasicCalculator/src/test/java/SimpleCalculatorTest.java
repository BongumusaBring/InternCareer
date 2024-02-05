import org.example.SimpleCalculator;
import org.junit.jupiter.api.Test;
import javax.swing.JButton;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {

    @Test
    public void testAddition() {
        // Arrange
        SimpleCalculator calculator = new SimpleCalculator();

        // Act
        calculator.getTextField().setText("5");
        calculator.getOperationButtonActionListener().actionPerformed(
                new java.awt.event.ActionEvent(calculator.getAddButton(), 0, "+")
        );

        calculator.getTextField().setText("3");
        calculator.getEqualsButtonActionListener().actionPerformed(
                new java.awt.event.ActionEvent(calculator.getEqualsButton(), 0, null)
        );

        // Assert
        assertEquals("8.0", calculator.getTextField().getText());
    }

    @Test
    public void testSubtraction() {
        // Arrange
        SimpleCalculator calculator = new SimpleCalculator();

        // Act
        calculator.getTextField().setText("10");
        calculator.getOperationButtonActionListener().actionPerformed(
                new java.awt.event.ActionEvent(calculator.getSubtractButton(), 0, "-")
        );

        calculator.getTextField().setText("3");
        calculator.getEqualsButtonActionListener().actionPerformed(
                new java.awt.event.ActionEvent(calculator.getEqualsButton(), 0, null)
        );

        // Assert
        assertEquals("7.0", calculator.getTextField().getText());
    }

    @Test
    public void testMultiplication() {
        // Arrange
        SimpleCalculator calculator = new SimpleCalculator();

        // Act
        calculator.getTextField().setText("5");
        calculator.getOperationButtonActionListener().actionPerformed(
                new java.awt.event.ActionEvent(calculator.getMultiplyButton(), 0, "*")
        );

        calculator.getTextField().setText("3");
        calculator.getEqualsButtonActionListener().actionPerformed(
                new java.awt.event.ActionEvent(calculator.getEqualsButton(), 0, null)
        );

        // Assert
        assertEquals("15.0", calculator.getTextField().getText());
    }

    @Test
    public void testDivision() {
        // Arrange
        SimpleCalculator calculator = new SimpleCalculator();

        // Act
        calculator.getTextField().setText("10");
        calculator.getOperationButtonActionListener().actionPerformed(
                new java.awt.event.ActionEvent(calculator.getDivideButton(), 0, "/")
        );

        calculator.getTextField().setText("2");
        calculator.getEqualsButtonActionListener().actionPerformed(
                new java.awt.event.ActionEvent(calculator.getEqualsButton(), 0, null)
        );

        // Assert
        assertEquals("5.0", calculator.getTextField().getText());
    }
}
