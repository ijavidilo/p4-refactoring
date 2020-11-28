package usantatecla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void givenTwoIntervalsThatIsIntersectedThenTrue() {
        Interval interval_one = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
        Interval interval_two = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();

        assertTrue(interval_one.isIntersected(interval_two));
    }

}