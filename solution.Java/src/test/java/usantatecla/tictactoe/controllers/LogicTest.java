package usantatecla.tictactoe.controllers;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

public class LogicTest {

    private Logic logic;

    @BeforeEach
    public void before() {
        this.logic = new Logic();
    }

    @Test
    public void testFirstControllerStartControllerThenOk() {
        MatcherAssert.assertThat(logic.getController(), is(instanceOf(StartController.class)));
    }

}
