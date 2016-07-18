/**
 * A collaboration of everyone in Development class 4.
 */

package fifteenpuzzledos;

/**
 * @author SamuelAaron
 * This class represents the View section of the application.
 */

// This contains two (2) methods which are "display" and "format" methods.
public class FifteenPuzzleDosView {
    
    // the "display" method prints the numbers into a grid pattern
    public void display(int[] squares) {
        System.out.println();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(format(squares[i * 4 + j]));
            System.out.println();
        }
    }
    
    // the "format" method provides a particular lay-out which adds the spaces for the numbers to appear on the command line
    private String format(int number) {
        if (number == 0) return "   ";
        return ((number < 10) ? " " : "") + number + " "; // adds spaces between the numbers laterally
    }
}