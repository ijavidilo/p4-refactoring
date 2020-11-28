package usantatecla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OpenMaxTest extends ExtremeTest {

    protected OpenMax openMax;

    @Before
    public void before() {
        super.before();
        this.openMax = this.createMax();
    }

    protected OpenMax createMax() {
        return new OpenMax(this.point.getEquals());
    }

    @Test
    public void givenMaxWhenIncludeWithLessValueThenTrue() {
        assertTrue(this.openMax.include(this.point.getLess()));
    }

    @Test
    public void givenMaxWhenIncludeWithEqualsValue() {
        assertFalse(this.openMax.include(this.point.getEquals()));
    }

    @Test
    public void givenMaxWhenIncludeWithGreaterValueThenTrue() {
        assertFalse(this.openMax.include(this.point.getGreater()));
    }

}
