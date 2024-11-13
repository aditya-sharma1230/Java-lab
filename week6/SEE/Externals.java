package SEE;

import CIE.Internals;
import java.util.Scanner;

public class Externals extends Internals {
    protected int[] externalMarks = new int[5];  // Array to store external marks
    protected int[] finalMarks = new int[5];     // Array to store final marks

    // Constructor to initialize arrays
    public Externals() {
        externalMarks = new int[5];
        finalMarks = new int[5];
    }

    // Method to input SEE marks for 5 subjects
    public void inputSEEmarks() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter External marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            externalMarks[i] = s.nextInt();
        }
    }

    // Method to calculate final marks (CIE + SEE)
    public void calculateFinalMarks() {
        for (int i = 0; i < 5; i++) {
            finalMarks[i] = marks[i] + externalMarks[i];  // Add internal and external marks
        }
    }

    // Method to display final marks
    public void displayFinalMarks() {
        displayStudentDetails();
        displayCIEmarks();
        System.out.println("Final Marks (CIE + SEE):");
        for (int i = 0; i < 5; i++) {
            System.out.println("Subject " + (i + 1) + ": " + finalMarks[i]);
        }
    }
}
