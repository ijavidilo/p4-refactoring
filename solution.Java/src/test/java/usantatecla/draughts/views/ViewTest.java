package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.utils.Console;
import usantatecla.draughts.utils.YesNoDialog;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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
    public void testVerifyZeroInteractionsConsoleThenOk() {
        verifyZeroInteractions(this.console);
    }


    @Test
    public void testStartViewPVThenOk() {
        this.view.write();

        verify(this.console).writeln(TITTLE);
    }

    @Test
    public void testResumeViewPVThenOk() {
        when(this.yesNoDialog.read(MESSAGE)).thenReturn(Boolean.TRUE);

        this.view.read();

        assertTrue(this.view.read());
    }

    @Test
    public void testPlayViewReadColorPVThenOk() {
        when(this.view.read(Color.BLACK)).thenReturn("negras");

        assertThat(this.view.read(Color.BLACK), is("negras"));
    }

    @Test
    public void testPlayViewWriteErrorPVThenOk() {
        this.view.writeError();

        verify(this.console).writeln(ERROR_MESSAGE);
    }

    @Test
    public void testPlayViewWritePlayControllerPVThenOk() {
        this.view.write();

        verify(this.console).writeln(Mockito.anyString());
    }

    @Test
    public void testPlayViewWriteLostPVThenOk() {
        this.view.writeLost();

        verify(this.console).writeln(LOST_MESSAGE);
    }
    
}
