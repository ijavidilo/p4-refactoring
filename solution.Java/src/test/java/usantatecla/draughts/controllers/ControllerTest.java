package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.State;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ControllerTest {

    private Game game;
    private State state;
    private Controller controller;

    @Before
    public void before() {
        this.game = new GameBuilder().build();
        this.state = new State();
        this.controller = new Controller(game, state);
    }

    @Test
    public void testGetDimensionThenOk() {
        assertThat(controller.getDimension(), is(equalTo(Coordinate.getDimension())));
    }

}
