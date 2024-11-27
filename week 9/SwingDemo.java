import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SwingDemo {
    SwingDemo() {
        // Create JFrame container
        JFrame jfrm = new JFrame("Divider App");
        jfrm.setSize(275, 150);
        jfrm.setLayout(new FlowLayout());
        // Terminate the application when the frame is closed
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text label for input instructions
        JLabel jlab = new JLabel("Enter the divisor and dividend:");

        // Add text fields for the two numbers (dividend and divisor)
        JTextField ajtf = new JTextField(8); // Dividend input field
        JTextField bjtf = new JTextField(8); // Divisor input field

        // Button to trigger calculation
        JButton button = new JButton("Calculate");

        // Labels to display errors, inputs, and the result
        JLabel err = new JLabel();   // Error message label
        JLabel alab = new JLabel();  // Label for dividend value
        JLabel blab = new JLabel();  // Label for divisor value
        JLabel anslab = new JLabel(); // Label for the result (answer)

        // Add components to the JFrame
        jfrm.add(err);    // Error label
        jfrm.add(jlab);   // Instruction label
        jfrm.add(ajtf);   // Dividend input field
        jfrm.add(bjtf);   // Divisor input field
        jfrm.add(button);  // Calculate button
        jfrm.add(alab);   // Display dividend value
        jfrm.add(blab);   // Display divisor value
        jfrm.add(anslab); // Display the result

        // ActionListener for the "Calculate" button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Parse input values as integers
                    int a = Integer.parseInt(ajtf.getText());
                    int b = Integer.parseInt(bjtf.getText());

                    // Perform division and display the result
                    int ans = a / b;
                    alab.setText("A = " + a);
                    blab.setText("B = " + b);
                    anslab.setText("Ans = " + ans);
                    err.setText(""); // Clear error message if no exception

                } catch (NumberFormatException e) {
                    // Catch invalid integer inputs (non-numeric)
                    alab.setText("");
                    blab.setText("");
                    anslab.setText("");
                    err.setText("Enter Only Integers!");
                } catch (ArithmeticException e) {
                    // Catch division by zero
                    alab.setText("");
                    blab.setText("");
                    anslab.setText("");
                    err.setText("B should be NON-zero!");
                }
            }
        });

        // Make the frame visible
        jfrm.setVisible(true);
    }

    public static void main(String args[]) {
        // Create frame on event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingDemo(); // Initialize the SwingDemo frame
            }
        });
    }
}
