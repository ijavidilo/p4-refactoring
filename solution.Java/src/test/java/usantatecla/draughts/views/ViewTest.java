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
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.utils.Console;
import usantatecla.draughts.utils.YesNoDialog;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ViewTest {

    private static final String TITTLE = "Draughts";
    private static final String MESSAGE = "¿Queréis jugar otra";
    private static final String COLOR_PARAM = "#color";
    private static final String[] COLOR_VALUES = {"blancas", "negras"};
    private static final String PROMPT = "Mueven las " + COLOR_PARAM + ": ";
    private static final String CANCEL_FORMAT = "-1";
    private static final String MOVEMENT_FORMAT = "[1-8]{2}(\\.[1-8]{2}){1,2}";
    private static final String ERROR_MESSAGE = "Error!!! Formato incorrecto";
    private static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";

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

    @Mock
    private YesNoDialog yesNoDialog;

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

    private String getStdinCoordinates(String coordinates) {
        return coordinates;
    }

    @Test
    public void testGivenPlayViewWhenInteractWithPlayControllerAndReadBadFormatCoordinatesThenCancel() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(anyString())).thenReturn(getStdinCoordinates("-1"));

        this.view.visit(this.playController);

        verify(this.playController).cancel();
    }

    @Test
    public void testGivenPlayViewWhenInteractWithPlayControllerAndReadCorrectCoordinatesThenMove() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(anyString())).thenReturn(getStdinCoordinates("11.22"));

        this.view.visit(this.playController);

        verify(this.playController).move(
                new Coordinate(0, 0),
                new Coordinate(1, 1)
        );
    }

    @Test
    public void testGivenPlayViewWhenInteractWithPlayControllerAndGameIsBlockedThenBlocked() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(anyString())).thenReturn(getStdinCoordinates("11.22"));
        when(this.playController.isBlocked()).thenReturn(Boolean.TRUE);

        this.view.visit(this.playController);

        verify(this.console).writeln("Derrota!!! No puedes mover tus fichas!!!");
    }

    @Test
    public void testGivenPlayViewWhenInteractWithPlayControllerAndReadWrongFormatCoordinatesThenWrongFormat() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(anyString()))
                .thenReturn(getStdinCoordinates("0"))
                .thenReturn(getStdinCoordinates("9999"))
                .thenReturn(getStdinCoordinates("abcd"))
                .thenReturn(getStdinCoordinates("aa.bb"))
                .thenReturn(getStdinCoordinates("11.aa"))
                .thenReturn("-1");

        this.view.visit(this.playController);

        verify(this.console, times(5)).writeln("Error!!! Formato incorrecto");
    }

    @Test(expected = AssertionError.class)
    public void testGivenViewWhenVisitNullPlayControllerThenError() {
        this.view.visit((PlayController) null);
    }

    @Test
    public void testGivenResumeViewWhenInteractWithResumeControllerThenReset() {
        when(this.yesNoDialog.read(Mockito.anyString())).thenReturn(Boolean.TRUE);

        this.view.visit(this.resumeController);

        verify(this.resumeController).reset();
    }

    @Test
    public void testGivenResumeViewWhenInteractWithResumeControllerThenNext() {
        when(this.yesNoDialog.read(Mockito.anyString())).thenReturn(Boolean.FALSE);

        this.view.visit(this.resumeController);

        verify(this.resumeController).next();
    }

    @Test(expected = AssertionError.class)
    public void testGivenViewWhenVisitNullResumeControllerThenError() {
        this.view.visit((ResumeController) null);
    }

    @Test
    public void testVerifyZeroInteractionsConsoleThenOk() {
        verifyZeroInteractions(this.console);
    }


    @Test
    public void testStartViewPVThenOk() {
        this.view.write();

        verify(this.console).writeln(TITTLE);
    }

}
