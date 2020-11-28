package usantatecla;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ClosedMaxTest extends OpenMaxTest {

    @Override
    protected OpenMax createMax() {
        return new ClosedMax(this.point.getEquals());
    }

    @Test
    @Override
    public void givenMaxWhenIncludeWithEqualsValue() {
        assertTrue(this.openMax.include(this.point.getEquals()));
    }

}
