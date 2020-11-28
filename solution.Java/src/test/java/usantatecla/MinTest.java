package usantatecla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MinTest {

    protected Min min;
    protected Point point;

    @Before
    public void before() {
        this.point = new Point(4.4);
        this.min = this.createMin();
    }

    protected Min createMin() {
        return new Min(this.point.getEquals());
    }

    @Test
    public void givenMinWhenIsWithinWithLessValueThenTrue() {
        assertFalse(this.min.isWithin(this.point.getLess()));
    }

    @Test
    public void givenMinWhenIsWithinWithEqualsValue() {
        assertFalse(this.min.isWithin(this.point.getEquals()));
    }

    @Test
    public void givenMinWhenIsWithinWithGreaterValueThenTrue() {
        assertTrue(this.min.isWithin(this.point.getGreater()));
    }

}

