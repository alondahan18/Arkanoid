import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The KeyPressStoppableAnimation class.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean stop;

    /**
     * constructor for the object.
     * @param sensor
     * @param key
     * @param animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboardSensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (!this.keyboardSensor.isPressed(key)) {
            this.isAlreadyPressed = false;
        }
        if (this.keyboardSensor.isPressed(key) && !this.isAlreadyPressed) {
            this.stop = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}
