import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for the background sprite.
 */
public class Background implements Sprite {
    private List<Ball> ballList;
    private List<Line> lineList;
    private List<Rectangle> rectangleList;
    private List<Color> ballColor;
    private List<Color> lineColor;
    private List<Color> recColor;

    /**
     * Constructor for the object.
     */
    public Background() {
        this.ballList = new ArrayList<>();
        this.lineList = new ArrayList<>();
        this.rectangleList = new ArrayList<>();
        this.ballColor = new ArrayList<>();
        this.lineColor = new ArrayList<>();
        this.recColor = new ArrayList<>();
    }

    @Override
    public void drawOn(DrawSurface d) {
        int size1 = this.rectangleList.size();
        for (int i = 0; i < size1; i++) {
            Point p = this.rectangleList.get(i).getUpperLeft();
            Rectangle r = this.rectangleList.get(i);
            d.setColor(this.recColor.get(i));
            d.fillRectangle((int) p.getX(), (int) p.getY(), (int) r.getWidth(), (int) r.getHeight());
        }
        int size2 = this.ballList.size();
        for (int j = 0; j < size2; j++) {
            this.ballList.get(j).drawOn(d);
            d.setColor(this.ballColor.get(j));
            Ball b = this.ballList.get(j);
            d.drawCircle(b.getX(), b.getY(), b.getSize());
        }
        int size3 = this.lineColor.size();
        for (int k = 0; k < size3; k++) {
            Line l = this.lineList.get(k);
            Point s = l.start();
            Point e = l.end();
            d.setColor(this.lineColor.get(k));
            d.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(), (int) e.getY());
        }
    }

    /**
     * adding a ball to the background.
     * @param b a aball
     */
    public void addBall(Ball b) {
        this.ballList.add(b);
    }

    /**
     * adding a line to the background.
     * @param l a line
     */
    public void addLine(Line l) {
        this.lineList.add(l);
    }

    /**
     * Adding a rectangle to the background.
     * @param rec the rec
     */
    public void addRec(Rectangle rec) {
        this.rectangleList.add(rec);
    }

    /**
     * Adding a color to the ball.
     * @param color the color
     */
    public void ballColor(Color color) {
        this.ballColor.add(color);
    }

    /**
     * Adding a color to the line.
     * @param color the color.
     */
    public void lineColor(Color color) {
        this.lineColor.add(color);
    }

    /**
     * adding a color to the rec.
     * @param color the color.
     */
    public void recColor(Color color) {
        this.recColor.add(color);
    }

    @Override
    public void timePassed() {

    }
}
