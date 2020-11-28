package usantatecla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MaxTest extends ExtremeTest {

    protected Max max;

    @Before
    public void before() {
        super.before();
        this.max = this.createMax();
    }

    protected Max createMax() {
        return new Max(this.point.getEquals());
    }

    @Test
    public void givenMaxWhenIncludeWithLessValueThenTrue() {
        assertTrue(this.max.include(this.point.getLess()));
    }

    @Test
    public void givenMaxWhenIncludeWithEqualsValue() {
        assertFalse(this.max.include(this.point.getEquals()));
    }

    @Test
    public void givenMaxWhenIncludeWithGreaterValueThenTrue() {
        assertFalse(this.max.include(this.point.getGreater()));
    }

}
