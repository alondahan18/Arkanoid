import java.util.List;

/**
 * the level information interface.
 */
public interface LevelInformation {
    /**
     * Get the amount of balls.
     * @return the num of balls
     */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     * Get the ball velocities.
     * @return the velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * Get the paddle speed.
     * @return the paddle speed.
     */
    int paddleSpeed();

    /**
     * Get the paddle width.
     * @return the paddle's width
     */
    int paddleWidth();
    // the level name will be displayed at the top of the screen.

    /**
     * Get the level name.
     * @return the name.
     */
    String levelName();
    // Returns a sprite with the background of the level

    /**
     * Get the background og the game.
     * @return the background.
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * Get the blocks.
     * @return the blocks.
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     * Get the number of blocks in the game.
     * @return the num of blocks.
     */
    int numberOfBlocksToRemove();

    /**
     * Get the location of the balls.
     * @return the location of the balls.
     */
    List<Point> ballLocation();
}
