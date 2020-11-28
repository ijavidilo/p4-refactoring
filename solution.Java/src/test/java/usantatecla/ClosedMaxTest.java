package usantatecla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
