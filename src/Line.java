//215314303 Alon Dahan

import java.util.ArrayList;

/**
 * Creating the new object "Line".
 */
public class Line {
    //start is the starting point of the line, end is the ending point
    private final Point start;
    private final Point end;

    /**
     * First constructor fot the object line.
     *
     * @param start the start point of the line.
     * @param end   the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Second constructor fot the object line.
     *
     * @param x1 the start point x value.
     * @param y1 the start point y value.
     * @param x2 the end point x value.
     * @param y2 the end point y value.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Calculating the length of the line.
     *
     * @return the length of the line.
     */
    public double length() {
        double x1 = this.start.getX(), y1 = this.start.getY(), x2 = this.end.getX(), y2 = this.end.getY();
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    /**
     * Finding the middle point of the line.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        double xMiddle = (this.start.getX() + this.end.getX()) / 2;
        double yMiddle = (this.start.getY() + this.end.getY()) / 2;
        Point a = new Point(xMiddle, yMiddle);
        return a;
    }

    /**
     * Return the start point of the line.
     *
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * Calculating the slope of the line.
     *
     * @return the slope of the line.
     */
    public double slope() {
        double x1 = this.start.getX(), y1 = this.start.getY(), x2 = this.end.getX(), y2 = this.end.getY();
        if (x1 != x2) {
            return (y1 - y2) / (x1 - x2);
        }
        return 0;
    }

    /**
     * Checking if a line is vertical.
     *
     * @return true if the line is vertical, false otherwise.
     */
    //the function is supposed to be activated only on lines which their slope is 0
    private boolean isVertical() {
        if (this.slope() != 0) {
            return false;
        }
        if (this.start.getX() == this.end.getX()) {
            return true;
        }
        return false;
    }

    /**
     * Checking if two lines are intersecting.
     *
     * @param other a line.
     * @return true if the lines are intersecting, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        //if both slope's 0
        if ((this.slope() == other.slope()) && this.slope() == 0) {
            //if one of them is vertical
            if (this.isVertical() && !other.isVertical()) {
                Point a = new Point(this.start.getX(), this.start.getY());
                if (other.isOnLine(a)) {
                    return true;
                }
            }
            if (!this.isVertical() && other.isVertical()) {
                Point a = new Point(other.start().getX(), this.start.getY());
                if (this.isOnLine(a)) {
                    return true;
                }
            }
        }
        //if the slopes are the same and not intersecting
        if ((this.slope() == other.slope()) && (!this.isOnLine(other.start()) && (!this.isOnLine(other.end())))) {
            return false;
        }
        //if we got here with the ame slopes we should return true
        if (this.slope() == other.slope()) {
            return true;
        }
        if (!this.isVertical() && !other.isVertical()) {
            //calculating the values of the intersection point
            double m1 = this.slope(), m2 = other.slope();
            double b1 = this.start.getY() - m1 * this.start.getX();
            double b2 = other.start().getY() - m2 * other.start().getX();
            double x = (b1 - b2) / (m2 - m1);
            double y = m1 * x + b1;
            Point a = new Point(x, y);
            //slopes are different but intersection is on the imaginary continuation
            if (!(this.isOnLine(a) && other.isOnLine(a))) {
                return false;
            }
            return true;
        }
        if (this.isVertical()) {
            double x = this.start.getX();
            double m = other.slope(), b = other.start().getY() - m * other.start().getX(), y = m * x + b;
            if (y >= this.start.getY() && y <= this.end.getY()) {
                return true;
            }
            if (y <= this.start.getY() && y >= this.end.getY()) {
                return true;
            }
        } else {
            double x = other.start().getX();
            double m = this.slope(), b = this.start.getY() - m * this.start.getX(), y = m * x + b;
            if (y >= other.start().getY() && y <= other.end().getY()) {
                return true;
            }
            if (y <= other.start().getY() && y >= other.end().getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checking if a point is on the real line (and not on the imaginary).
     *
     * @param other a point.
     * @return true if the point os on the line, false otherwise.
     */
    //private because it's only needed for a different method in this class
    public boolean isOnLine(Point other) {
        double x1 = this.start.getX(), x2 = this.end.getX(), x3 = other.getX();
        if ((x3 >= x1 && x3 <= x2) || (x3 <= x1 && x3 >= x2)) {
            return true;
        }
        return false;
    }

    /**
     * Finding the intersection point values.
     *
     * @param other a line.
     * @return the intersection point if it exists, null otherwise.
     */
    public Point intersectionWith(Line other) {
        //the lines don't intersect
        if (!this.isIntersecting(other)) {
            return null;
        }
        double m1 = this.slope(), m2 = other.slope();
        //different slopes
        if (m1 != m2 && !this.isVertical() && !other.isVertical()) {
            //calculating the point values
            double b1 = this.start.getY() - m1 * this.start.getX();
            double b2 = other.start().getY() - m2 * other.start().getX();
            double x = (b1 - b2) / (m2 - m1);
            double y = m1 * x + b1;
            Point a = new Point(x, y);
            if (this.isOnLine(a) && other.isOnLine(a)) {
                return a;
            }
            return null;
        }
        if (m1 != m2 && this.isVertical()) {
            double b = other.start().getY() - m2 * other.start().getX(), y = m2 * this.start.getX() + b;
            return new Point(this.start.getX(), y);
        }
        if (m1 != m2 && other.isVertical()) {
            double b = this.start.getY() - m2 * this.start.getX(), y = m2 * other.start().getX() + b;
            return new Point(other.start().getX(), y);
        }
        //if both slopes are 0
        if (m1 == 0) {
            //one of them is vertical
            if (this.isVertical() && !other.isVertical()) {
                Point a = new Point(this.start.getX(), other.start().getY());
                if (other.isOnLine(a)) {
                    return a;
                }
            }
            if (!this.isVertical() && other.isVertical()) {
                Point a = new Point(other.start.getX(), this.start.getY());
                if (this.isOnLine(a)) {
                    return a;
                }
            }
        }
        //at this point the slopes are equal but not 0 (might be if both are\aren't vertical)
        if (this.start.equals(other.end())) {
            return this.start;
        }
        if (this.start.equals(other.start())) {
            return this.start;
        }
        if (this.end.equals(other.end())) {
            return this.end;
        }
        if (this.start.equals(other.start())) {
            return this.end;
        }
        //if we got here nothing worked
        return null;
    }

    /**
     * Checking if two lines are the same.
     *
     * @param other a line
     * @return true if the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        if (this.start.equals((other.start())) && this.end.equals(other.end())) {
            return true;
        }
        if (this.start.equals(other.end()) && this.end.equals((other.start()))) {
            return true;
        }
        return false;
    }

    /**
     * Getting the closest intersection point of a line with a rectangle.
     * @param rect the rectangle of collision.
     * @return the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line a = new Line(this.start, this.end);
        ArrayList<Point> list = rect.intersectionPoints(a);
        if (list.size() == 0) {
            return null;
        }
        Point closest = list.get(0);
        double min = this.start.distance(closest);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).distance(this.start) < min) {
                closest = list.get(i);
                min = this.start.distance(closest);
            }
        }
        return closest;
    }

}
