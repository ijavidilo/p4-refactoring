package usantatecla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MaxTest {

    protected Max max;
    protected Point point;

    @Before
    public void before() {
        this.point = new Point(4.4);
        this.max = this.createMax();
    }

    protected Max createMax() {
        return new Max(this.point.getEquals());
    }

    @Test
    public void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.max.isWithin(this.point.getLess()));
    }

    @Test
    public void givenMaxWhenIsWithinWithEqualsValue() {
        assertFalse(this.max.isWithin(this.point.getEquals()));
    }

    @Test
    public void givenMaxWhenIsWithinWithGreaterValueThenTrue() {
        assertFalse(this.max.isWithin(this.point.getGreater()));
    }

}
