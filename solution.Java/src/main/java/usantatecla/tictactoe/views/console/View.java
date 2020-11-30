package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.ControllersVisitor;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public class View extends usantatecla.tictactoe.views.View implements ControllersVisitor {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	private StartController startController;

	public View(StartController startController, PlayController playController, ResumeController resumeController) {
        this.startController = startController;

        this.startView = new StartView();
		this.playView = new PlayView(playController);
		this.resumeView = new ResumeView(resumeController);
	}

	@Override
	protected void start(){
		this.startView.interact(startController);
	}

	@Override
	protected void play(){
		this.playView.interact();
	}

	@Override
	protected boolean isResumed(){
		return this.resumeView.interact();
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	@Override
	public void visit(PlayController playController) {

	}

	@Override
	public void visit(ResumeController resumeController) {

	}
}
