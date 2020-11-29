package usantatecla;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ExtremeTest {

    protected Point point;
    private Extreme extremeOpenMin;
    private Extreme extremeOpenMax;
    private Extreme extremeClosedMin;
    private Extreme extremeClosedMax;

    @Before
    public void before() {
        this.point = new Point(4.4);
        this.extremeOpenMin = new OpenMin(4.4);
        this.extremeOpenMax = new OpenMax(4.4);
        this.extremeClosedMin = new ClosedMin(4.4);
        this.extremeClosedMax = new ClosedMax(4.4);
    }

    @Test
    public void givenPointWhenIsCreatedThenTrue() {
        assertThat((this.point), is(instanceOf(Point.class)));

        assertThat(this.point.getEquals(), is(this.point.getEquals()));
        assertThat(this.point.getLess(), is(this.point.getEquals() - Point.DEVIATION));
        assertThat(this.point.getGreater(), is(this.point.getEquals() + Point.DEVIATION));

        assertThat(this.point.getEquals(), is(not(5555.0)));
        assertThat(this.point.getLess(), is(not(this.point.getEquals() + Point.DEVIATION)));
        assertThat(this.point.getGreater(), is(not(this.point.getEquals() - Point.DEVIATION)));
    }

    @Test
    public void givenExtremeInstanceWhenIsCreatedThenOk() {
        assertThat((this.extremeOpenMin), is(instanceOf(OpenMin.class)));
        assertThat((this.extremeOpenMax), is(instanceOf(OpenMax.class)));
        assertThat((this.extremeClosedMin), is(instanceOf(ClosedMin.class)));
        assertThat((this.extremeClosedMax), is(instanceOf(ClosedMax.class)));
    }

    @Test
    public void givenExtremeWhenIncludePointThenTest() {
        assertThat((this.extremeOpenMin.include(this.point.getEquals())), is(Boolean.FALSE));
        assertThat((this.extremeOpenMin.include(this.point.getGreater())), is(Boolean.TRUE));
        assertThat((this.extremeOpenMin.include(this.point.getLess())), is(Boolean.FALSE));

        assertThat((this.extremeOpenMax.include(this.point.getEquals())), is(Boolean.FALSE));
        assertThat((this.extremeOpenMax.include(this.point.getGreater())), is(Boolean.FALSE));
        assertThat((this.extremeOpenMax.include(this.point.getLess())), is(Boolean.TRUE));

        assertThat((this.extremeClosedMin.include(this.point.getEquals())), is(Boolean.TRUE));
        assertThat((this.extremeClosedMin.include(this.point.getGreater())), is(Boolean.TRUE));
        assertThat((this.extremeClosedMin.include(this.point.getLess())), is(Boolean.FALSE));

        assertThat((this.extremeClosedMax.include(this.point.getEquals())), is(Boolean.TRUE));
        assertThat((this.extremeClosedMax.include(this.point.getGreater())), is(Boolean.FALSE));
        assertThat((this.extremeClosedMax.include(this.point.getLess())), is(Boolean.TRUE));
    }

}
