package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class PawnTest {

    private Pawn pawn;

    @Before
    public void before() {
        pawn = new Pawn(Color.WHITE);
    }

    @Test(expected = NullPointerException.class)
    public void testNullCoordinateIsCorrectDiagonalMovementThenNull() {
        assertThat(pawn.isCorrectDiagonalMovement(1, 0, null), is(nullValue()));
    }

    @Test
    public void testNotAdvancedIsCorrectDiagonalMovementThenError() {
        Coordinate[] coordinatesList = new Coordinate[3];
        coordinatesList[0] = new Coordinate(5, 1);
        coordinatesList[1] = new Coordinate(6, 1);
        coordinatesList[2] = new Coordinate(7, 1);

        assertThat(pawn.isCorrectDiagonalMovement(2, 1, coordinatesList), is(Error.NOT_ADVANCED));
    }

    @Test
    public void testGetCodesThenOk() {
        char[] CHARACTERS = {'b', 'n'};
        assertThat(pawn.getCodes(), is(equalTo(CHARACTERS)));
    }

}
