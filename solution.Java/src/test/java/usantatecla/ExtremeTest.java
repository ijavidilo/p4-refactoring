package usantatecla;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ExtremeTest {

    protected Point point;

    @Before
    public void before() {
        this.point = new Point(4.4);
    }

    @Test
    public void givenPointWhenIsCreatedThenTrue() {
        assertThat((this.point), is(instanceOf(Point.class)));

        assertThat(this.point.getEquals(), is(this.point.getValue()));
        assertThat(this.point.getLess(), is(this.point.getValue() - Point.DEVIATION));
        assertThat(this.point.getGreater(), is(this.point.getValue() + Point.DEVIATION));

        assertThat(this.point.getEquals(), is(not(5555.0)));
        assertThat(this.point.getLess(), is(not(this.point.getValue() + Point.DEVIATION)));
        assertThat(this.point.getGreater(), is(not(this.point.getValue() - Point.DEVIATION)));
    }

}
