package usantatecla;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ClosedMinTest extends MinTest {

    @Override
    protected Min createMin() {
        return new ClosedMin(this.point.getEquals());
    }

    @Test
    @Override
    public void givenMinWhenIncludeWithEqualsValue() {
        assertTrue(this.min.include(this.point.getEquals()));
    }

}
