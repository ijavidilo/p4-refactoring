package usantatecla.draughts.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ColorTest {

    @Test
    public void testIsInitialRowWhiteColor() {
        assertThat(Color.WHITE.isInitialRow(4), is(Boolean.FALSE));
        assertThat(Color.WHITE.isInitialRow(5), is(Boolean.TRUE));
        assertThat(Color.WHITE.isInitialRow(999), is(Boolean.TRUE));
    }

    @Test
    public void testIsInitialRowBlackColor() {
        assertThat(Color.BLACK.isInitialRow(3), is(Boolean.FALSE));
        assertThat(Color.BLACK.isInitialRow(2), is(Boolean.TRUE));
        assertThat(Color.BLACK.isInitialRow(-999), is(Boolean.TRUE));
    }

    private static Coordinate whitePawnCoordinate() {
        Coordinate coordinate = new Coordinate(1, 1);
        return coordinate;
    }

    private static Coordinate blackPawnCoordinate() {
        Coordinate coordinate = new Coordinate(0, 1);
        return coordinate;
    }

    @Test
    public void testWhiteInitialColor() {
        assertThat(Color.getInitialColor(whitePawnCoordinate()), is(nullValue()));
    }

    @Test
    public void testBlackInitialColor() {
        assertThat(Color.getInitialColor(blackPawnCoordinate()), is(equalTo(Color.BLACK)));
    }

}
