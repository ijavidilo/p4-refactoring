package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogicTest {

    private Logic logic;

    @Before
    public void before() {
        this.logic = new Logic();
    }

    @Test
    public void testFirstControllerStartControllerThenOk() {
        assertThat(logic.getController(), is(instanceOf(StartController.class)));
    }

}
