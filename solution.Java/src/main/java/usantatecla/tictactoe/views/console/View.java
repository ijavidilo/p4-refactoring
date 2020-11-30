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
	private PlayController playController;
	private ResumeController resumeController;

	public View(StartController startController, PlayController playController, ResumeController resumeController) {
        this.startController = startController;
        this.playController = playController;
        this.resumeController = resumeController;

        this.startView = new StartView();
		this.playView = new PlayView();
		this.resumeView = new ResumeView();
	}

	@Override
	protected void start(){
		this.startView.interact(this.startController);
	}

	@Override
	protected void play(){
		this.playView.interact(this.playController);
	}

	@Override
	protected boolean isResumed(){
		return this.resumeView.interact(this.resumeController);
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	@Override
	public void visit(PlayController playController) {
		this.playView.interact(playController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}
}
