import biuoop.DrawSurface;

/**
 * the Collidable interface.
 */
public interface Collidable {
    // Return the "collision shape" of the object.

    /**
     * Getting the object shape.
     * @return the object's shape.
     */
    Rectangle getCollisionRectangle();

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * Update the hitting object velocity.
     * @param collisionPoint the collision point of the objects.
     * @param currentVelocity the hitting object's current velocity
     * @param hitter the ball that hits the collidable
     * @return the updated velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * Draw the objects on the surface.
     * @param d the surface
     */
    void drawOn(DrawSurface d);
}