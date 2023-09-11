import biuoop.DrawSurface;

/**
 * The animation interface.
 */
public interface Animation {
    /**
     * drawing a single frame on the surface.
     * @param d the durface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Checking if the animation should stop.
     * @return true if the animation should stop
     */
    boolean shouldStop();
}
