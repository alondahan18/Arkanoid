import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The lose screen class.
 */
public class LoseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;

    /**
     * The constructor of the object.
     * @param k the keyboard
     * @param score the score
     */
    public LoseScreen(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.RED);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.WHITE);
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + this.score.getValue(), 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
