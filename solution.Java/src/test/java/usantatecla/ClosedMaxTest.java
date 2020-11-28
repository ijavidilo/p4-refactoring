package usantatecla;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ClosedMaxTest extends MaxTest {

    @Override
    protected Max createMax() {
        return new ClosedMax(this.point.getEquals());
    }

    @Test
    @Override
    public void givenMaxWhenIsWithinWithEqualsValue() {
        assertTrue(this.max.isWithin(this.point.getEquals()));
    }

}
