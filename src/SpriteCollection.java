//Alon Dahan 215314303
import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * Creating the sprite collection object.
 */
public class SpriteCollection {
    private ArrayList<Sprite> list;

    /**
     * Constructor for the sprite collection object.
     */
    public SpriteCollection() {
        this.list = new ArrayList<Sprite>();
    }

    /**
     * Adding a sprite to the collection.
     * @param s a sprite
     */
    public void addSprite(Sprite s) {
        this.list.add(s);
    }

    /**
     * Removing a sprite from the collection.
     * @param s the removed sprite.
     */
    public void removeSpri(Sprite s) {
        this.list.remove(s);
    }
    // call timePassed() on all sprites.

    /**
     * Activating the time passed method on the list's elements.
     */
    public void notifyAllTimePassed() {
        int n = this.list.size();
        for (int i = 0; i < n; i++) {
            if (i < this.list.size()) {
                this.list.get(i).timePassed();
            }
        }
    }

    // call drawOn(d) on all sprites.

    /**
     * Drawing all the list's elements on the surface.
     * @param d the surface
     */
    public void drawAllOn(DrawSurface d) {
        int n = this.list.size();
        for (int i = 0; i < n; i++) {
            this.list.get(i).drawOn(d);
        }
    }
}
