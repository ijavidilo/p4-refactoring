package usantatecla.draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import usantatecla.draughts.controllers.AllControllerTest;
import usantatecla.draughts.models.AllModelTests;
import usantatecla.draughts.views.AllViewTests;

@RunWith(Suite.class)
@SuiteClasses({
        AllModelTests.class,
        AllControllerTest.class,
        AllViewTests.class
})
public class AllTests {

}
