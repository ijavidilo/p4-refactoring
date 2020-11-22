package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StartControllerTest {

    private State state;
    private StartController startController;

    @Before
    public void before() {
        this.state = new State();
        this.startController = new StartController(new GameBuilder().build(), state);
    }

    @Test
    public void testInGameStateThenOk() {
        this.startController.start();
        assertThat(this.state.getValueState(), is(StateValue.IN_GAME));
    }

    @Test
    public void testCorrectGetPawnPieceThenOk() {
        assertThat(this.startController.getPiece(new Coordinate(2, 1)), is(instanceOf(Pawn.class)));
    }

    @Test
    public void testIncorrectGetPawnPieceThenNull() {
        assertNull(this.startController.getPiece(new Coordinate(0, 0)));
    }

    @Test(expected = AssertionError.class)
    public void testNullGetPawnPieceThenError() {
        assertNull(this.startController.getPiece(null));
    }

    @Test(expected = AssertionError.class)
    public void testAcceptMethodNullObjectThenError() {
        this.startController.accept(null);
    }


}
