package usantatecla.draughts.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TurnBuilderTest {

    @Test
    public void testGetActualColor() {
        assertThat(new TurnBuilder().build().getColor(), is(Color.WHITE));
        assertThat(new TurnBuilder().color(Color.BLACK).build().getColor(), is(Color.BLACK));
    }

    @Test
    public void testGetOppositeColor() {
        assertThat(new TurnBuilder().build().getOppositeColor(), is(Color.BLACK));
    }

    @Test
    public void testChangeColor() {
        TurnTest turnTest = new TurnBuilder().build();
        turnTest.change();

        assertThat(turnTest.getColor(), is(Color.BLACK));
    }

}
