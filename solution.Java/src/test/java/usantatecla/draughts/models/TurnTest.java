package usantatecla.draughts.models;

public class TurnTest {

    private Color color;

    TurnTest(Color color) {
        this.color = color;
    }

    void change() {
        this.color = this.getOppositeColor();
    }

    Color getColor() {
        return this.color;
    }

    Color getOppositeColor() {
        return Color.values()[(this.color.ordinal() + 1) % 2];
    }


}