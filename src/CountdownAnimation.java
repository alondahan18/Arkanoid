import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * The count down animation class.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private double timePerNumber;
    private String name;

    /**
     * Constructor for the object.
     * @param numOfSeconds the number of seconds the player gonna wait
     * @param countFrom the counting from number
     * @param gameScreen the game screen behind
     * @param name the name of the level
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, String name) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.timePerNumber = (this.numOfSeconds / this.countFrom) * 1000;
        this.name = name;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();

        long startTime = System.currentTimeMillis(); // timing
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 15);
        d.setColor(Color.BLACK);
        d.drawText(600, 10, "Level: " + name, 10);
        // game-specific logic
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.RED);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2 + 20, this.countFrom + "...", 50);
        long usedTime = System.currentTimeMillis() - startTime;
        long milliSecondLeftToSleep = (long) this.timePerNumber - usedTime;
        if (milliSecondLeftToSleep > 0 && this.countFrom != 3) {
            sleeper.sleepFor(milliSecondLeftToSleep);
        }
        this.countFrom--;
    }

    @Override
    public boolean shouldStop() {
        if (this.countFrom == -1) {
            return true;
        }
        return false;
    }
}
