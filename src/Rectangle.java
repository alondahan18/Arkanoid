//Alon Dahan 215314303
import java.util.ArrayList;

/**
 * Creating the rectangle object.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    // Create a new rectangle with location and width/height.

    /**
     * Constructor for the rectangle object.
     * @param upperLeft the top left point of the rect.
     * @param width the width of the rect.
     * @param height the height of the rect.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    // Return a (possibly empty) List of intersection points
    // with the specified line.

    /**
     * Getting a list of intersection points with a line.
     * @param line the line
     * @return a list of intersection points.
     */
    public ArrayList<Point> intersectionPoints(Line line) {
        ArrayList<Point> list = new ArrayList<Point>();
        //part 1
        Point rightTop = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Point leftBottom = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point rightBottom = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        Line topLeftTopRight = new Line(this.upperLeft, rightTop);
        Line topLeftBottomLeft = new Line(this.upperLeft, leftBottom);
        Line topRightBottomRight = new Line(rightTop, rightBottom);
        Line bottomLeftBottomRight = new Line(leftBottom, rightBottom);
        Point a = line.intersectionWith(topLeftTopRight);
        Point b = line.intersectionWith(topLeftBottomLeft);
        Point c = line.intersectionWith(topRightBottomRight);
        Point d = line.intersectionWith(bottomLeftBottomRight);
        if (a != null) {
            list.add(a);
        }
        if (b != null) {
            list.add(b);
        }
        if (c != null) {
            list.add(c);
        }
        if (d != null) {
            list.add(d);
        }
        return list;
    }

    // Return the width and height of the rectangle

    /**
     * Getting the rectangle's width.
     * @return the width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Getting the rectangle's height.
     * @return the height.
     */
    public double getHeight() {
        return this.height;
    }

    // Returns the upper-left point of the rectangle.

    /**
     * Getting the upper-left point of the rectangle.
     * @return the upper-left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}
