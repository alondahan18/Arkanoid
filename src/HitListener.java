//Alon Dahan 215314303

/**
 * Interface for the listeners.
 */
public interface HitListener {
    // This method is called whenever the beingHit object is hit.
    // The hitter parameter is the Ball that's doing the hitting.

    /**
     * An event that occurs whenever the block is being hit.
     * @param beingHit the block.
     * @param hitter the ball that hits.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
