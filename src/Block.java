//Alon Dahan 215314303

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Creating the new object block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    /**
     * A constructor for the block object.
     *
     * @param rect  the block's shape.
     * @param color the block's color.
     */
    public Block(Rectangle rect, java.awt.Color color) {
        this.rect = rect;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * Getting the block's shape.
     *
     * @return the block's shape
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Changing the velocity of an object that is about to hit the block.
     *
     * @param collisionPoint  the collision point of the objects
     * @param currentVelocity the current velocity of the hitting object
     * @param hitter the ball that hits
     * @return the updated velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double x1 = this.rect.getUpperLeft().getX();
        double x2 = this.rect.getUpperLeft().getX() + this.rect.getWidth();
        double y1 = this.rect.getUpperLeft().getY();
        double y2 = (this.rect.getUpperLeft().getY() + this.rect.getHeight());
        double dx = currentVelocity.getDX();
        double dy = currentVelocity.getDY();
        if (Math.round(collisionPoint.getX()) == Math.round(x1)
                || Math.round(collisionPoint.getX()) == Math.round(x2)) {
            dx = (-1) * currentVelocity.getDX();
        }
        if (Math.round(collisionPoint.getY()) == Math.round(y1)
                || Math.round(collisionPoint.getY()) == Math.round(y2)) {
            dy = (-1) * currentVelocity.getDY();
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }

    /**
     * Method for drawing the ball on the screen.
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        Rectangle a = this.rect;
        int x = (int) a.getUpperLeft().getX(), y = (int) a.getUpperLeft().getY();
        surface.setColor(Color.BLACK);
        surface.drawRectangle(x, y, (int) a.getWidth(), (int) a.getHeight());
        surface.setColor(this.color);
        surface.fillRectangle(x, y, (int) a.getWidth(), (int) a.getHeight());
    }

    /**
     * The time passed method from the sprite interface.
     */
    public void timePassed() {

    }

    /**
     * Adding the block to a game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Removing a block from the game.
     * @param gameLevel the game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
