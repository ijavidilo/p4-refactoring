package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.utils.YesNoDialog;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ResumeViewTest {

    @Mock
    private ResumeController resumeController;

    @Mock
    private YesNoDialog yesNoDialog;

    @InjectMocks
    private ResumeView resumeView;

    @Before
    public void before() {
        initMocks(this);
    }

    @Test
    public void testGivenResumeViewWhenInteractWithResumeControllerThenReset() {
        when(this.yesNoDialog.read(Mockito.anyString())).thenReturn(Boolean.TRUE);

        this.resumeView.interact(resumeController);

        verify(this.resumeController).reset();
    }

    @Test
    public void testGivenResumeViewWhenInteractWithResumeControllerThenNext() {
        when(this.yesNoDialog.read(Mockito.anyString())).thenReturn(Boolean.FALSE);

        this.resumeView.interact(resumeController);

        verify(this.resumeController).next();
    }

    @Test(expected = AssertionError.class)
    public void testGivenResumeViewWhenInteractWithNullResumeControllerThenError() {
        this.resumeView.interact(null);
    }

    @Test
    public void testVerifyYesNoDialogInteractionThenOk() {
        verifyZeroInteractions(this.yesNoDialog);
    }

}
