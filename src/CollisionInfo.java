//Alon Dahan 215314303

/**
 * The Collision Info class.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Constructor for the collisionInfo object.
     * @param collisionPoint the collision point
     * @param collisionObject the collision object
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionObject = collisionObject;
        this.collisionPoint = collisionPoint;
    }
    //the point at which the collision occurs.

    /**
     * Getting the collision point.
     * @return the collision point
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    // the collidable object involved in the collision.

    /**
     * Getting the collision object.
     * @return the collision object.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
