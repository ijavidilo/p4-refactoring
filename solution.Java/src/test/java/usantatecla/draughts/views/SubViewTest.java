package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import usantatecla.draughts.utils.Console;

import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.MockitoAnnotations.initMocks;

public class SubViewTest {

    @Mock
    private Console console;

    @Before
    public void before() {
        initMocks(this);
    }

    @Test
    public void testVerifyZeroInteractionsConsoleThenOk() {
        verifyZeroInteractions(this.console);
    }

}