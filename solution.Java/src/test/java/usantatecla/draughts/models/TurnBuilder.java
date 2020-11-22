package usantatecla.draughts.models;

public class TurnBuilder {

    private Color color;

    public TurnBuilder(){
        this.color = Color.WHITE;
    }

    public TurnBuilder color(Color color){
        this.color = color;
        return this;
    }

    public TurnTest build(){
        return new TurnTest(this.color);
    }
}
