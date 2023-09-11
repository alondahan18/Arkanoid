//Alon Dahan 215314303

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Creating the paddle object.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;
    private Color color;

    /**
     * @param rect
     * @param keyboard
     */
    public Paddle(Rectangle rect, KeyboardSensor keyboard) {
        this.rect = rect;
        this.keyboard = keyboard;
    }

    /**
     *
     */
    public void moveLeft() {
        Point a = this.rect.getUpperLeft();
        if (a.getX() != 25) {
            Point upperLeft = new Point(a.getX() - 5, a.getY());
            this.rect = new Rectangle(upperLeft, this.rect.getWidth(), this.rect.getHeight());
        }
    }

    /**
     *
     */
    public void moveRight() {
        Point a = this.rect.getUpperLeft();
        if (a.getX() != 775 - this.rect.getWidth()) {
            Point upperLeft = new Point(a.getX() + 5, a.getY());
            this.rect = new Rectangle(upperLeft, this.rect.getWidth(), this.rect.getHeight());
        }
    }

    // Sprite

    /**
     *
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * @param d the surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        Point a = this.rect.getUpperLeft();
        d.fillRectangle((int) a.getX(), (int) a.getY(), (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    // Collidable

    /**
     * Getting the paddle's shape.
     * @return the paddle's shape
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * Updating the hitting object's velocity.
     * @param collisionPoint the collision point of the objects.
     * @param currentVelocity the hitting object's current velocity
     * @param hitter the ball that hits the paddle.
     * @return the updated velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDX(), dy = currentVelocity.getDY();
        double speed = Math.sqrt(dx * dx + dy * dy);
        double width = this.rect.getWidth();
        double xCol = collisionPoint.getX(), xRec = this.rect.getUpperLeft().getX();
        Point leftTop = this.rect.getUpperLeft();
        Point rightTop = new Point(leftTop.getX() + this.rect.getWidth(), leftTop.getY());
        Point leftBottom = new Point(leftTop.getX(), leftTop.getY() + this.rect.getHeight());
        Point rightBottom = new Point(leftTop.getX() + this.rect.getWidth(), leftTop.getY() + this.rect.getHeight());
        Line topLeftBottomLeft = new Line(leftTop, leftBottom);
        Line topRightBottomRight = new Line(rightTop, rightBottom);
        //checking the region of the hit
        if (xCol >= xRec && xCol < xRec + width / 5) {
            Velocity v = currentVelocity.fromAngleAndSpeed(300, speed);
            return v;
        }
        if (xCol >= xRec + width / 5 && xCol < xRec + 2 * width / 5) {
            Velocity v = currentVelocity.fromAngleAndSpeed(330, speed);
            return v;
        }
        if (xCol >= xRec + 2 * width / 5 && xCol < xRec + 3 * width / 5) {
            currentVelocity.setDY(dy * (-1));
            return currentVelocity;
        }
        if (xCol >= xRec + 3 * width / 5 && xCol < xRec + 4 * width / 5) {
            Velocity v = currentVelocity.fromAngleAndSpeed(30, speed);
            return v;
        }
        if (xCol >= xRec + 4 * width / 5 && xCol <= xRec + width) {
            Velocity v = currentVelocity.fromAngleAndSpeed(60, speed);
            return v;
        }
        if (topLeftBottomLeft.start().getX() == collisionPoint.getX()) {
            if (collisionPoint.getY() > leftTop.getY() && collisionPoint.getY() < leftBottom.getY()) {
                currentVelocity.setDX((-1) * currentVelocity.getDX());
            }
        }
        if (topRightBottomRight.start().getX() == collisionPoint.getX()) {
            if (collisionPoint.getY() > rightTop.getY() && collisionPoint.getY() < rightBottom.getY()) {
                currentVelocity.setDX((-1) * currentVelocity.getDX());
            }
        }
        return currentVelocity;
    }

    // Add this paddle to the game.

    /**
     * Adding the paddle to the game.
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * Setting the paddle's color.
     * @param color the color.
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
