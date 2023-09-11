//Alon Dahan 215314303

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;


import java.awt.Color;

/**
 * Creating the game object.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation level;

    /**
     * Constructor for the game object.
     * @param animationRunner the animation runner.
     * @param levelInformation the level info.
     * @param score the score.
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner animationRunner, Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter();
        this.remainingBalls = new Counter();
        this.score = score;
        this.runner = animationRunner;
        this.running = true;
        this.keyboard = this.runner.getGui().getKeyboardSensor();
        this.level = levelInformation;
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        // stopping condition
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
        }
        if (this.remainingBlocks.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        Sleeper sleeper = new Sleeper();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        long startTime = System.currentTimeMillis(); // timing
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 15);
        d.setColor(Color.BLACK);
        d.drawText(600, 10, "Level: " + this.level.levelName(), 10);

        // game-specific logic
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            PauseScreen pause = new PauseScreen(this.keyboard);
            String s = this.keyboard.SPACE_KEY;
            KeyPressStoppableAnimation k = new KeyPressStoppableAnimation(this.keyboard, s, pause);
            this.runner.run(k);
        }


        long usedTime = System.currentTimeMillis() - startTime;
        long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
        if (milliSecondLeftToSleep > 0) {
            sleeper.sleepFor(milliSecondLeftToSleep);
        }
    }

    /**
     * Adding a collidable to the game.
     *
     * @param c a collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Adding a sprite to the game.
     *
     * @param s a sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.

    /**
     * Initializing the game.
     */
    public void initialize() {
        //creating the game objects
        this.addSprite(this.level.getBackground());
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        this.addSprite(scoreIndicator);
        BlockRemover blockRemover = new BlockRemover(this, this.remainingBlocks);
        BallRemover ballRemover = new BallRemover(this, this.remainingBalls);
        ScoreTrackingListener score = new ScoreTrackingListener(this.score);
        Rectangle rec = new Rectangle(new Point(400 - level.paddleWidth() / 2.0, 565), this.level.paddleWidth(), 10);
        Paddle paddle = new Paddle(rec, this.runner.getGui().getKeyboardSensor());
        paddle.setColor(Color.ORANGE);
        paddle.addToGame(this);
        for (int i = 0; i < this.level.numberOfBalls(); i++) {
            Ball ball = new Ball(this.level.ballLocation().get(i), 5, Color.WHITE);
            ball.setVelocity(this.level.initialBallVelocities().get(i));
            ball.setGameEnvironment(this.environment);
            ball.addToGame(this);
            this.remainingBalls.increase(1);
        }
        Block top = new Block(new Rectangle(new Point(0, 15), 800, 10), Color.GRAY);
        Block death = new Block(new Rectangle(new Point(0, 615), 800, 25), Color.GRAY);
        Block left = new Block(new Rectangle(new Point(0, 25), 25, 575), Color.GRAY);
        Block right = new Block(new Rectangle(new Point(775, 25), 25, 575), Color.GRAY);
        top.addToGame(this);
        death.addHitListener(ballRemover);
        death.addToGame(this);
        left.addToGame(this);
        right.addToGame(this);
        //creating the blocks
        for (int j = 0; j < this.level.numberOfBlocksToRemove(); j++) {
            Block block = this.level.blocks().get(j);
            remainingBlocks.increase(1);
            block.addHitListener(blockRemover);
            block.addHitListener(score);
            block.addToGame(this);
        }
    }

    // Run the game -- start the animation loop.

    /**
     * Running the game.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites, this.level.levelName()));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    /**
     * Removing a collidable from the game.
     *
     * @param c the removed collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeColli(c);
    }

    /**
     * Removing a sprite from the game.
     *
     * @param s the removed sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSpri(s);
    }

    /**
     * Getting the amount of blocks remained.
     * @return the num of blocks.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }

    /**
     * Getting the amount of balls remained.
     * @return the num of balls.
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }
}
