package usantatecla.draughts.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CoordinateTest {

    @Test
    public void testCorrectCreationCoordinateThenOk() {
        assertThat(new Coordinate(2, 1).getRow(), is(2));
        assertThat(new Coordinate(2, 1).getColumn(), is(1));
    }

    @Test
    public void testBlackCoordinateThenIsTrue() {
        assertThat(new Coordinate(2, 1).isBlack(), is(Boolean.TRUE));
    }

    @Test
    public void testBlackCoordinateThenIsFalse() {
        assertThat(new Coordinate(5, 1).isBlack(), is(Boolean.FALSE));
    }

    @Test
    public void testCorrectLimitCoordinateIsLastThenOk() {
        assertThat(new Coordinate(7, 0,0,7,8).isLast(), is(Boolean.TRUE));
    }

    @Test
    public void testErrorLimitCoordinateIsLastThenKO() {
        assertThat(new Coordinate(55, 0).isLast(), is(Boolean.FALSE));
    }

    @Test
    public void testCorrectLimitCoordinateIsFirstThenOk() {
        assertThat(new Coordinate(0, 0).isFirst(), is(Boolean.TRUE));
    }

    @Test
    public void testErrorLimitCoordinateIsFirstThenKO() {
        assertThat(new Coordinate(55, 0).isFirst(), is(Boolean.FALSE));
    }

}