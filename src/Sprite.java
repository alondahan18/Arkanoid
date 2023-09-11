//Alon Dahan 215314303
import biuoop.DrawSurface;

/**
 * Creating the sprite interface.
 */
public interface Sprite {
    // draw the sprite to the screen

    /**
     * Drawing the sprite on the surface.
     * @param d the surface
     */
    void drawOn(DrawSurface d);
    // notify the sprite that time has passed

    /**
     * The time passed method.
     */
    void timePassed();
}
