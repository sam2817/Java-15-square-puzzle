/**
 * This application follows the instructions in the 15 square puzzle website.
 * A collaboration of everyone in Dev class 4.
*/

package fifteenpuzzledos;

import java.util.InputMismatchException;
import java.util.Scanner; // a simple text scanner which can parse primitive types and strings using regular expressions.

/**
 * @author SamuelAaron
 * This class represents the Model section of the application.
 */

// This only contains one (1) method which the "main" method.
public class FifteenPuzzleDos {
    
    // the "main" method provides the user the ability to move the blank space within the grid
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FifteenPuzzleDosView puzzleView = new FifteenPuzzleDosView();
        FifteenPuzzleDosController puzzleController = new FifteenPuzzleDosController();
        
        int number;
        
        while (true) {
            puzzleView.display(puzzleController.squares);
            System.out.print("\nMove: ");
            try {
                number = input.nextInt();
                puzzleController.move(number);
                if (number == 0)
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Error!");
                input.next();
            }
        }
    }
}