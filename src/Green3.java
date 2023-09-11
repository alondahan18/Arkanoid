import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the third level class.
 */
public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        Velocity v = new Velocity(-2, -3);
        list.add(v);
        Velocity v2 = new Velocity(3, -2);
        list.add(v2);
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    // the level name will be displayed at the top of the screen.
    @Override
    public String levelName() {
        return "Green 3";
    }

    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground() {
        Background back = new Background();
        back.addRec(new Rectangle(new Point(25, 25), 750, 600));
        back.recColor(Color.GREEN);
        back.addRec(new Rectangle(new Point(100, 500), 50, 100));
        back.recColor(Color.BLACK);
        back.addRec(new Rectangle(new Point(117, 460), 17, 40));
        back.recColor(Color.darkGray);
        back.addRec(new Rectangle(new Point(123, 260), 4, 200));
        back.recColor(Color.gray);
        back.addBall(new Ball(new Point(125, 250), 10, Color.RED));
        back.ballColor(Color.red);
        back.addBall(new Ball(new Point(125, 250), 7, Color.ORANGE));
        back.ballColor(Color.ORANGE);
        back.addBall(new Ball(new Point(125, 250), 3, Color.yellow));
        back.ballColor(Color.YELLOW);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Rectangle rec = new Rectangle(new Point(105 + 9 * j, 505 + 19 * i), 4, 14);
                back.addRec(rec);
                back.recColor(Color.WHITE);
            }
        }
        return back;
    }

    // The Blocks that make up this level, each block contains
    // its size, color and location.
    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10 - i; j++) {
                Rectangle rectangle = new Rectangle(new Point(725 - 50 * j, 100 + 30 * i), 50, 30);
                if (i == 0) {
                    Block block = new Block(rectangle, Color.CYAN);
                    list.add(block);
                }
                if (i == 1) {
                    Block block = new Block(rectangle, Color.PINK);
                    list.add(block);
                }
                if (i == 2) {
                    Block block = new Block(rectangle, Color.RED);
                    list.add(block);
                }
                if (i == 3) {
                    Block block = new Block(rectangle, Color.BLUE);
                    list.add(block);
                }
                if (i == 4) {
                    Block block = new Block(rectangle, Color.YELLOW);
                    list.add(block);
                }
            }
        }
        return list;
    }

    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }

    @Override
    public List<Point> ballLocation() {
        List<Point> list = new ArrayList<>();
        Point p = new Point(312, 314);
        Point p2 = new Point(673, 400);
        list.add(p);
        list.add(p2);
        return list;
    }
}
