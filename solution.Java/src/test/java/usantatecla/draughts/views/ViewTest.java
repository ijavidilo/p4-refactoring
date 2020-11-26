package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.utils.Console;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ViewTest {

    @Mock
    private PlayView playView;

    @Mock
    private ResumeView resumeView;

    @Mock
    private InteractorController interactorController;

    @Mock
    private StartController startController;

    @Mock
    private PlayController playController;

    @Mock
    private ResumeController resumeController;

    @Mock
    private Console console;

    @InjectMocks
    private View view;

    @Before
    public void before() {
        initMocks(this);
    }

    @Test
    public void testGivenViewWhenInteractWithControllersThenOk() {
        this.view.interact(this.interactorController);
        verify(this.interactorController).accept(this.view);

        this.view.interact(this.startController);
        verify(this.startController).accept(this.view);

        this.view.interact(this.playController);
        verify(this.playController).accept(this.view);

        this.view.interact(this.resumeController);
        verify(this.resumeController).accept(this.view);
    }

    @Test(expected = AssertionError.class)
    public void testGivenViewWhenInteractWithNullControllerThenError() {
        this.view.interact(null);
    }

    @Test
    public void testGivenViewWhenVisitStartControllerThenOk() {
        this.view.visit(this.startController);

        verify(this.console).writeln(Mockito.anyString());
        verify(this.startController).start();
    }

    @Test(expected = AssertionError.class)
    public void testGivenViewWhenVisitNullStartControllerThenError() {
        this.view.visit((StartController) null);
    }

    @Test
    public void testGivenViewWhenVisitPlayControllerThenOk() {
        this.view.visit(this.playController);
        verify(this.playView).interact(this.playController);
    }

    @Test(expected = AssertionError.class)
    public void testGivenViewWhenVisitNullPlayControllerThenError() {
        this.view.visit((PlayController) null);
    }

    @Test
    public void testGivenViewWhenVisitResumeControllerThenOk() {
        this.view.visit(this.resumeController);
        verify(this.resumeView).interact(this.resumeController);
    }

    @Test(expected = AssertionError.class)
    public void testGivenViewWhenVisitNullResumeControllerThenError() {
        this.view.visit((ResumeController) null);
    }

}
