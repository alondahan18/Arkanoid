
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.util.List;

/**
 * The game flow class.
 */
public class GameFlow {

    private AnimationRunner animationRunner;
    private Counter score;
    private KeyboardSensor keyboardSensor;
    private Sleeper sleeper;

    /**
     * Constructor for the object.
     */
    public GameFlow() {
        this.animationRunner = new AnimationRunner(new GUI("Ass6Game", 800, 600));
        this.score = new Counter();
        this.keyboardSensor = this.animationRunner.getGui().getKeyboardSensor();
        this.sleeper = new Sleeper();
    }

    /**
     * running the levels.
     * @param levels the levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        int count = 0;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.animationRunner, this.score);

            level.initialize();

            while (!level.shouldStop()) {
                level.run();
            }

            if (level.getRemainingBalls().getValue() == 0) {
                KeyboardSensor keyboardSensor = this.animationRunner.getGui().getKeyboardSensor();
                LoseScreen l = new LoseScreen(keyboardSensor, this.score);
                String s = KeyboardSensor.SPACE_KEY;
                KeyPressStoppableAnimation k = new KeyPressStoppableAnimation(keyboardSensor, s, l);
                this.animationRunner.run(k);
                this.animationRunner.getGui().close();
            }
            if (level.getRemainingBlocks().getValue() == 0) {
                sleeper.sleepFor(75);
                count++;
            }

        }
        if (count == levels.size()) {
            KeyboardSensor keyboardSensor = this.animationRunner.getGui().getKeyboardSensor();
            WinScreen w = new WinScreen(keyboardSensor, this.score);
            KeyPressStoppableAnimation k = new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY, w);
            this.animationRunner.run(k);
            this.animationRunner.getGui().close();
        }
    }
}
