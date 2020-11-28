package usantatecla;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BuilderIntervalTest.class,
        ClosedMaxTest.class,
        ClosedMinTest.class,
        IntervalTest.class,
        MaxTest.class,
        MinTest.class})
public class AllIntervalTest {
}