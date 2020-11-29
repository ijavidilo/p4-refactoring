package usantatecla;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class IntervalTest {

    private Point left;
    private Point right;
    private IntervalBuilder intervalBuilder;

    @Before
    public void before() {
        this.left = new Point(-2.2);
        this.right = new Point(4.4);
        this.intervalBuilder = new IntervalBuilder();
    }

    @Test
    public void givenIntervalOpenOpenWhenIncludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));

        assertTrue(interval.include(left.getGreater()));
        assertTrue(interval.include(right.getLess()));

        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervalClosedOpenWhenIncludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervalOpenClosedWhenIncludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervalClosedClosedWhenIncludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test(expected = AssertionError.class)
    public void givenOneNullIntervalWhenIsIntersectedThenError() {
        Interval interval_one = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();

        interval_one.isIntersected(null);
    }

    @Test
    public void givenOneIntervalTestLeftIsIntersectedTest() {
        Interval interval_one = new IntervalBuilder().open(new Point(-2.2).getEquals()).open(new Point(4.4).getEquals()).build();

        List<Pair<Interval, Boolean>> intervalList = Arrays.asList(
                new Pair<Interval, Boolean>(new IntervalBuilder().open(new Point(-5.0).getEquals()).open(new Point(-2.2).getEquals()).build(), Boolean.FALSE),
                new Pair<Interval, Boolean>(new IntervalBuilder().open(new Point(-5.0).getEquals()).closed(new Point(-2.2).getEquals()).build(), Boolean.FALSE),
                new Pair<Interval, Boolean>(new IntervalBuilder().open(new Point(-5.0).getEquals()).open(new Point(2).getEquals()).build(), Boolean.TRUE),
                new Pair<Interval, Boolean>(new IntervalBuilder().open(new Point(-5.0).getEquals()).closed(new Point(55).getEquals()).build(), Boolean.TRUE),
                new Pair<Interval, Boolean>(new IntervalBuilder().open(new Point(-5.0).getEquals()).closed(new Point(-3.0).getEquals()).build(), Boolean.FALSE)
        );

        for (Pair<Interval, Boolean> interval : intervalList) {
            assertThat(interval_one.isIntersected(interval.getKey()), is(interval.getValue()));
        }
    }

    @Test
    public void givenOneIntervalTestRightIsIntersectedTest() {
        Interval interval_one = new IntervalBuilder().open(new Point(-2.2).getEquals()).open(new Point(4.4).getEquals()).build();

        List<Pair<Interval, Boolean>> intervalList = Arrays.asList(
                new Pair<Interval, Boolean>(new IntervalBuilder().open(new Point(4.4).getEquals()).open(new Point(10).getEquals()).build(), Boolean.FALSE),
                new Pair<Interval, Boolean>(new IntervalBuilder().closed(new Point(4.4).getEquals()).closed(new Point(10).getEquals()).build(), Boolean.FALSE),
                new Pair<Interval, Boolean>(new IntervalBuilder().open(new Point(2).getEquals()).open(new Point(10).getEquals()).build(), Boolean.TRUE),
                new Pair<Interval, Boolean>(new IntervalBuilder().open(new Point(5).getEquals()).closed(new Point(10).getEquals()).build(), Boolean.FALSE)
        );

        for (Pair<Interval, Boolean> interval : intervalList) {
            assertThat(interval_one.isIntersected(interval.getKey()), is(interval.getValue()));
        }
    }

    @Test
    public void givenOneIntervalTestMiddleOpenOpenIsIntersectedTest() {
        Interval interval_one = new IntervalBuilder().open(new Point(-2.2).getEquals()).open(new Point(4.4).getEquals()).build();

        List<Pair<Interval, Boolean>> intervalList = Arrays.asList(
                new Pair<Interval, Boolean>(new IntervalBuilder().open(new Point(-2.2).getEquals()).open(new Point(4.4).getEquals()).build(), Boolean.TRUE),
                new Pair<Interval, Boolean>(new IntervalBuilder().closed(new Point(-2.2).getEquals()).closed(new Point(4.4).getEquals()).build(), Boolean.TRUE),
                new Pair<Interval, Boolean>(new IntervalBuilder().open(new Point(-2.3).getEquals()).open(new Point(4.5).getEquals()).build(), Boolean.TRUE),
                new Pair<Interval, Boolean>(new IntervalBuilder().open(new Point(-2.1).getEquals()).open(new Point(4.5).getEquals()).build(), Boolean.TRUE)
        );

        for (Pair<Interval, Boolean> interval : intervalList) {
            assertThat(interval_one.isIntersected(interval.getKey()), is(interval.getValue()));
        }
    }

}