//215314303 Alon Dahan

import biuoop.DrawSurface;

/**
 * In this class we will create the object "Ball".
 */
public class Ball implements Sprite {
    //center is the center point of the ball, size is the radius, color is obvious.
    //velocity too...
    private Point center;
    private final int size;
    private final java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * A constructor for the ball object.
     *
     * @param center the center point
     * @param r      the radius
     * @param color  the color
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.size = r;
        this.color = color;
    }


    /**
     * Getting the x value of the center point.
     *
     * @return the x value of the center point
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Getting the y value of the center point.
     *
     * @return the y value of the center point
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Getting the ball's radius size.
     *
     * @return the radius size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Getting the ball's color.
     *
     * @return the ball's color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Drawing the ball on the surface.
     *
     * @param d a DrawSurface object, you can draw on it.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.getColor());
        d.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * Setting the ball's velocity.
     *
     * @param v the new velocity of the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Setting the ball's velocity in other way.
     *
     * @param dx the speed on the x coordinate.
     * @param dy the speed on the y coordinate.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Getting the ball's velocity.
     *
     * @return the ball's velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Moving the ball by his velocity.
     *
     * @param right  the right boundary of the frame
     * @param left   the left boundary of the frame
     * @param bottom the bottom boundary of the frame
     * @param top    the top boundary of the frame
     */
    public void moveOneStep(int right, int left, int bottom, int top) {
        Point a = this.getVelocity().applyToPoint(this.center);
        //what if it's about to go out from the right
        if (a.getX() + this.size > right) {
            this.velocity = new Velocity(this.velocity.getDX() * (-1), this.velocity.getDY());
            a = new Point(right - this.size, a.getY());
        }
        //what if it's about to go out from the left
        if (a.getX() - this.size < left) {
            this.velocity = new Velocity(this.velocity.getDX() * (-1), this.velocity.getDY());
            a = new Point(this.size + left, a.getY());
        }
        //what if it's about to go out from the bottom
        if (a.getY() + this.size > bottom) {
            this.velocity = new Velocity(this.velocity.getDX(), this.velocity.getDY() * (-1));
            a = new Point(a.getX(), bottom - this.size);
        }
        //what if it's about to go out from the top
        if (a.getY() - this.size < top) {
            this.velocity = new Velocity(this.velocity.getDX(), this.velocity.getDY() * (-1));
            a = new Point(a.getX(), this.size + top);
        }
        this.center = a;
    }

    /**
     * Setting the ball's game environment.
     *
     * @param gameEnvironment the game environment we want to set.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Returning the ball's game environment.
     *
     * @return the ball's game environment
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * Moving the ball on the screen.
     */
    public void moveOneStep() {
        //creating the imaginary line
        double endX = this.center.getX() + 1000 * this.getVelocity().getDX();
        double endY = this.center.getY() + 1000 * this.getVelocity().getDY();
        Point end = new Point(endX, endY);
        Line trajectory = new Line(this.center, end);
        if (this.gameEnvironment.getClosestCollision(trajectory).collisionObject() == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            Point a = this.getVelocity().applyToPoint(this.center);
            Point b = this.gameEnvironment.getClosestCollision(trajectory).collisionPoint();
            CollisionInfo c = this.gameEnvironment.getClosestCollision(trajectory);
            if (a.distance(b) <= this.size * 2) {
                this.velocity = c.collisionObject().hit(this, b, this.velocity);
            }
            this.center = a;
        }

    }

    /**
     * Permanante one of the sprite interface method.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Adding the ball to a game.
     *
     * @param g a game that will have the ball
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Removing a ball from the game.
     * @param g the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }


    /**
     * Getting the y value of a point on the ball by the x value.
     * @param x the x value
     * @return the y value
     */
    public int yBYx(int x) {
        double result = this.getY() + Math.sqrt(this.size * this.size - (x - this.getX()) * (x - this.getX()));
        return (int) result;
    }
}
