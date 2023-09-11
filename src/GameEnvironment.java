//Alon Dahan 215314303

import java.util.ArrayList;

/**
 * Creating the game environment object.
 */
public class GameEnvironment {
    private ArrayList<Collidable> list;

    /**
     * The constructor of the object.
     */
    public GameEnvironment() {
        this.list = new ArrayList<Collidable>();
    }

    // add the given collidable to the environment.

    /**
     * Adding a collidable to the game environment.
     *
     * @param c a collidable
     */
    public void addCollidable(Collidable c) {
        this.list.add(c);
    }

    /**
     * Removing a collidable from the game environment.
     * @param c the removed collidable
     */
    public void removeColli(Collidable c) {
        this.list.remove(c);
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     * Finding the closest collision by the trajectory line.
     *
     * @param trajectory the imaginary line that the object is moving on
     * @return the closest collision point and object.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        int n = this.list.size();
        if (n == 0) {
            return null;
        }
        Point closestPoint = null;
        Collidable closestCollision = null;
        double min = trajectory.length() + 1;
        //finding the closest collision
        for (int i = 0; i < n; i++) {
            Point a = trajectory.closestIntersectionToStartOfLine(this.list.get(i).getCollisionRectangle());
            if (a != null && a.distance(trajectory.start()) < min) {
                min = a.distance(trajectory.start());
                closestCollision = this.list.get(i);
                closestPoint = a;
            }
        }
        return new CollisionInfo(closestPoint, closestCollision);
    }

    /**
     * Getting the list.
     *
     * @return the lost
     */
    public ArrayList<Collidable> getList() {
        return this.list;
    }
}
