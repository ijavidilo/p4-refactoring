package usantatecla;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BuilderIntervalTest.class,
        ClosedMaxTest.class,
        ClosedMinTest.class,
        ExtremeTest.class,
        IntervalTest.class,
        OpenMaxTest.class,
        OpenMinTest.class})
public class AllIntervalTest {
}