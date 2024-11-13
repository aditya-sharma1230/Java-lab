import SEE.Externals;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline character

        // Array of Externals objects to handle multiple students
        Externals[] students = new Externals[n];

        for (int i = 0; i < n; i++) {
            students[i] = new Externals();
            System.out.println("Enter details for Student " + (i + 1));
            students[i].inputStudentDetails();  // Input student details
            students[i].inputCIEmarks();        // Input CIE marks
            students[i].inputSEEmarks();        // Input SEE marks
            students[i].calculateFinalMarks();  // Calculate final marks
            students[i].displayFinalMarks();    // Display final marks
        }
    }
}
