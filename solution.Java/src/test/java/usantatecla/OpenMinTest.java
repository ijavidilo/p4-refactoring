package usantatecla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OpenMinTest extends ExtremeTest {

    protected OpenMin openMin;

    @Before
    public void before() {
        super.before();
        this.openMin = this.createMin();
    }

    protected OpenMin createMin() {
        return new OpenMin(this.point.getEquals());
    }

    @Test
    public void givenMinWhenIncludeWithLessValueThenTrue() {
        assertFalse(this.openMin.include(this.point.getLess()));
    }

    @Test
    public void givenMinWhenIncludeWithEqualsValue() {
        assertFalse(this.openMin.include(this.point.getEquals()));
    }

    @Test
    public void givenMinWhenIncludeWithGreaterValueThenTrue() {
        assertTrue(this.openMin.include(this.point.getGreater()));
    }

}

