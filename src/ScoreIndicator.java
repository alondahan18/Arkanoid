//Alon Dahan 215314303

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Class for the score indicator.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * Constructor for the score indicator.
     * @param score the score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(400, 10, "Score: " + this.score.getValue(), 10);
    }

    @Override
    public void timePassed() {

    }
}
