package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class DraughtTest {

    private Draught draught;

    @Before
    public void before() {
        draught = new Draught(Color.WHITE);
    }

    @Test
    public void testNullButCorrectDiagonalMovementThenNull() {
        assertThat(draught.isCorrectDiagonalMovement(1, 0, null), is(nullValue()));
    }

    @Test
    public void testTooMuchEatingIsCorrectDiagonalMovementThenError() {
        assertThat(draught.isCorrectDiagonalMovement(2, 0, null), is(Error.TOO_MUCH_EATINGS));
    }

    @Test
    public void testGetCodeThenOk() {
        assertThat(draught.getColor(), is(Color.WHITE));
    }

    @Test(expected = AssertionError.class)
    public void testNullGetCodeThenAssertionError() {
        new Draught(null).getColor();
    }
}
