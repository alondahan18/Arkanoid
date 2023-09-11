//Alon Dahan 215314303

/**
 * An interface for the notifiers.
 */
public interface HitNotifier {
    // Add hl as a listener to hit events.

    /**
     * Adding a listener.
     * @param hl a listener.
     */
    void addHitListener(HitListener hl);
    // Remove hl from the list of listeners to hit events.

    /**
     * Re3moving a listener.
     * @param hl a listener.
     */
    void removeHitListener(HitListener hl);
}
