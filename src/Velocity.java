//215314303 Alon Dahan

/**
 * In this class we will create the object "Velocity".
 */
public class Velocity {
    //dx for the x coordinate velocity, dy for the y coordinate velocity
    private double dx;
    private double dy;
    /**
     * A constructor for velocity.
     * @param dx the velocity in the x coordinate
     * @param dy the velocity in the y coordinate
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * A different constructor for velocity.
     * @param angle the angle the ball moves in.
     * @param speed the ball's total speed.
     * @return the velocity of each coordinate.
     */
    public Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = speed *  (-1) * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * Applying the point position by the velocity.
     * @param p the starting position
     * @return the new point's position
     */
    public Point applyToPoint(Point p) {
        Point a = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return a;
    }
    /**
     * Getting the x coordinate velocity.
     * @return the x coordinate velocity
     */
    public double getDX() {
        return this.dx;
    }
    /**
     * Getting the y coordinate velocity.
     * @return the y coordinate velocity
     */
    public double getDY() {
        return this.dy;
    }

    /**
     * Setting the x coordinate velocity.
     * @param dx the updated velocity.
     */
    public void setDX(double dx) {
        this.dx = dx;
    }

    /**
     * Setting the y coordinate velocity.
     * @param dy the updated velocity.
     */
    public void setDY(double dy) {
        this.dy = dy;
    }

}
