/**
 * A collaboration of everyone in Development class 4.
 */

package fifteenpuzzledos;

import java.util.Random;

/**
 * @author SamuelAaron
 * This class represents the Controller section of the application.
 */

// This contains seven (7) methods which are "move", "tryAbove", "tryBelow", "tryLeft", "tryRight", and "swap" methods including a constructor "FifteenPuzzleDosController". 
public class FifteenPuzzleDosController {
    
    final private Random  rn      = new Random();
    public static int[]   squares = new int[16];
    
    public FifteenPuzzleDosController() {
        for (int i = 1; i < squares.length; i++)
            squares[i - 1] = i;
        for (int i = 0; i < 400; i++)
            move(rn.nextInt(squares.length - 1) + 1);
    }
    
    // the "move" method specifically moves the blank space
    public void move(int number) {
        if (number >= squares.length)
            return;
        int i;
        for (i = 0; i < squares.length; i++)
            if (squares[i] == number) 
                // squares[i] += 10;
                break;
        if (tryAbove(i)) return;
        if (tryBelow(i)) return;
        if (tryLeft(i))  return;
        if (tryRight(i)) return;
    }
    
    // the "tryAbove" method tries to check whether the blank space is above then swaps/moves a single number or the whole line towards its original position
    private boolean tryAbove(int pos) {
        if (pos < 4)
            return false;
        if (squares[pos - 4] != 0 && ! tryAbove(pos - 4))
            return false;
        swap(pos, pos - 4);
        return true;
    }
    
    // the "tryBelow" method tries to check whether the blank space is below then swaps/moves a single number or the  whole line towards its original position
    private boolean tryBelow(int pos) {
        if (pos > 11)
            return false;
        if (squares[pos + 4] != 0 && ! tryBelow(pos + 4))
            return false;
        swap(pos, pos + 4);
        return true;
    }
  
    // the "tryLeft" method tries to check whether the blank space to its left then swaps/moves a single number or the whole line towards its original position
    private boolean tryLeft(int pos) {
        if (pos % 4 == 0)
            return false;
        if (squares[pos - 1] != 0 && ! tryLeft(pos - 1))
            return false;
        swap(pos, pos - 1);
        return true;
    }
  
    // the "tryRight" method tries to check whether the blank space to its right then swaps/moves a single number or the whole line towards its original position
    private boolean tryRight(int pos) {
        if (pos % 4 == 3)
            return false;
        if (squares[pos + 1] != 0 && ! tryRight(pos + 1))
            return false;
        swap(pos, pos + 1);
        return true;
    }

    // the "swap" method allows the application to know ho far the blank space is able to move
    private void swap(int one, int two) {
        int     temp = squares[one];
        squares[one] = squares[two];
        squares[two] = temp;
    }
}