//Alon Dahan 215314303

/**
 * Creating the new object "Point".
 */
public class Point {
    //x for the x coordinate value, same for y
    private final double x;
    private final double y;

    /**
     * Constructor for a new point.
     * @param x the value of the x coordinate.
     * @param y is the value of the y coordinate.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculating the distance between two points.
     * @param other a point.
     * @return the distance between the points.
     */
    public double distance(Point other) {
        double otherX = other.getX(), otherY = other.getY();
        return Math.sqrt(((this.x - otherX) * (this.x - otherX)) + ((this.y - otherY) * (this.y - otherY)));
    }

    /**
     * Checking if two points are the same point.
     * @param other a point
     * @return true if it's the same point, false otherwise
     */
    public boolean equals(Point other) {
        if (Double.compare(this.x, other.getX()) == 0 && Double.compare(this.y, other.getY()) == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returning the x value of a point.
     * @return the x value
     */
    public double getX() {
        return this.x;
    }
    /**
     * Returning the y value of a point.
     * @return the y value
     */
    public double getY() {
        return this.y;
    }

}
