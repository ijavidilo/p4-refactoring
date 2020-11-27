package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;
import usantatecla.draughts.views.View;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ResumeControllerTest {

    private static final String MESSAGE = "¿Queréis jugar otra";

    @Mock
    private View view;

    @Mock
    private State state;

    @Mock
    private ResumeController resumeController;

    @Before
    public void before() {
        initMocks(this);
    }

    @Test
    public void testNextStateThenOk() {
        when(this.view.read()).thenReturn(Boolean.FALSE);
        when(this.state.getValueState()).thenReturn(StateValue.INITIAL);
        this.state.next();

        this.resumeController.control();

        assertThat(this.state.getValueState(), is(StateValue.INITIAL));
        verify(this.state, times(1)).next();
    }

}
