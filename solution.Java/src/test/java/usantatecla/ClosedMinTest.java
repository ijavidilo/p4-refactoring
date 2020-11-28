package usantatecla;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ClosedMinTest extends OpenMinTest {

    @Override
    protected OpenMin createMin() {
        return new ClosedMin(this.point.getEquals());
    }

    @Test
    @Override
    public void givenMinWhenIncludeWithEqualsValue() {
        assertTrue(this.openMin.include(this.point.getEquals()));
    }

}
