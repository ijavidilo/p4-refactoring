package usantatecla.draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        BoardTest.class,
        ColorTest.class,
        CoordinateTest.class,
        DirectionTest.class,
        DraughtTest.class,
        GameBuilderTest.class,
        PawnTest.class,
        PieceTest.class,
        StateTest.class,
        TurnBuilderTest.class
})
public class AllModelTests {
}
