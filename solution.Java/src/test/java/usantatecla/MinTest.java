package usantatecla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MinTest extends ExtremeTest {

    protected Min min;

    @Before
    public void before() {
        super.before();
        this.min = this.createMin();
    }

    protected Min createMin() {
        return new Min(this.point.getEquals());
    }

    @Test
    public void givenMinWhenIncludeWithLessValueThenTrue() {
        assertFalse(this.min.include(this.point.getLess()));
    }

    @Test
    public void givenMinWhenIncludeWithEqualsValue() {
        assertFalse(this.min.include(this.point.getEquals()));
    }

    @Test
    public void givenMinWhenIncludeWithGreaterValueThenTrue() {
        assertTrue(this.min.include(this.point.getGreater()));
    }

}

