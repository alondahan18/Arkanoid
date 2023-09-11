import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The win screen class.
 */
public class WinScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;

    /**
     * the constructor.
     * @param k the keyboard.
     * @param score the score.
     */
    public WinScreen(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.green);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.WHITE);
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + this.score.getValue(), 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
