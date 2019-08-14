package tictactoe4x4;

import com.ds.tictactoe4x4.TicTacToeVariant;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TicTacToeVariantSpec {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    private TicTacToeVariant ticTacToe;

    @Before
    public void before() {
        ticTacToe = new TicTacToeVariant();
    }

    // Req 1 - placing pieces
    @Test
    public void whenPieceOutsideXAxisThenRuntimeException() {
        expected.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }

    @Test
    public void whenPieceOutsideYAxisThenRuntimeException() {
        expected.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void whenOccupiedSpaceThenRunTimeException() {
        ticTacToe.play(1,2);
        expected.expect(RuntimeException.class);
        ticTacToe.play(1,2);
    }

    // Req 2 - adding two player support/
    @Test
    public void whenFirstTurnThenX() {
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void givenXwhenNextTurnThen0() {
        ticTacToe.play(1,2);
        assertEquals('O', ticTacToe.nextPlayer());
    }

//    @Test
//    public void givenOWhenNextTurnThenX() {
//        ticTacToe.play(1,2); // O
//        ticTacToe.play(1, 3); // X
//        assertEquals('X', ticTacToe.nextPlayer());
//    }

    // Req 3 - Winning conditions
    @Test
    public void whenPlayThenNoWinner() {
        String actual = ticTacToe.play(1,1);
        assertEquals("No winner", actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // O
        ticTacToe.play(3,1); // X
        ticTacToe.play(3,2); // O
        String actual = ticTacToe.play(4, 1);
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        ticTacToe.play(1,1); // X
        ticTacToe.play(2, 1); // O
        ticTacToe.play(1, 2); // X
        ticTacToe.play(2, 2);// O
        ticTacToe.play(1, 3); // X
        ticTacToe.play(2,3); // O
        String actual = ticTacToe.play(1, 4); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndDiagonalLineFromBottomToTopThenWinner() {
        ticTacToe.play(1,1); // X
        ticTacToe.play(1,2); // O
        ticTacToe.play(2,2); // X
        ticTacToe.play(1,3); // O
        ticTacToe.play(3,3); // X
        ticTacToe.play(1,4); // O
        String actual = ticTacToe.play(4,4); // X
        assertEquals("X is the winner", actual);
    }
}
