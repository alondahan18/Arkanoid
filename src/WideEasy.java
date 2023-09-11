import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the second level class.
 */
public class WideEasy implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        Velocity v = new Velocity(-3, -3);
        list.add(v);
        Velocity v2 = new Velocity(-2, -3);
        list.add(v2);
        Velocity v3 = new Velocity(-2, -3);
        list.add(v3);
        Velocity v4 = new Velocity(-2, -2);
        list.add(v4);
        Velocity v5 = new Velocity(-3, -2);
        list.add(v5);
        Velocity v6 = new Velocity(2, -2);
        list.add(v6);
        Velocity v7 = new Velocity(3, -2);
        list.add(v7);
        Velocity v8 = new Velocity(4, -3);
        list.add(v8);
        Velocity v9 = new Velocity(2, -3);
        list.add(v9);
        Velocity v10 = new Velocity(3, -3);
        list.add(v10);
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    // the level name will be displayed at the top of the screen.
    @Override
    public String levelName() {
        return "Wide Easy";
    }

    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground() {
        Background back = new Background();
        back.addRec(new Rectangle(new Point(25, 25), 750, 600));
        back.recColor(Color.cyan);
        Ball ball2 = new Ball(new Point(150, 125), 80, Color.ORANGE);
        Ball ball3 = new Ball(new Point(150, 125), 70, Color.yellow);
        back.addBall(ball2);
        back.addBall(ball3);
        back.ballColor(Color.lightGray);
        back.ballColor(Color.orange);
        back.ballColor(Color.yellow);
        for (int i = 0; i < 75; i++) {
            Line line = new Line(75 + 2 * i, ball2.yBYx(75 + 2 * i), 25 + 8 * i, 250);
            back.addLine(line);
            if (i % 2 == 0) {
                back.lineColor(Color.orange);
            } else {
                back.lineColor(Color.yellow);
            }
        }
        return back;
    }

    // The Blocks that make up this level, each block contains
    // its size, color and location.
    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Rectangle rec = new Rectangle(new Point(725 - 50 * i, 250), 50, 30);
            if (i < 2) {
                Block block = new Block(rec, Color.lightGray);
                list.add(block);
            }
            if (i > 1 && i < 4) {
                Block block = new Block(rec, Color.pink);
                list.add(block);
            }
            if (i > 3 && i < 6) {
                Block block = new Block(rec, Color.blue);
                list.add(block);
            }
            if (i > 5 && i < 9) {
                Block block = new Block(rec, Color.green);
                list.add(block);
            }
            if (i > 8 && i < 11) {
                Block block = new Block(rec, Color.yellow);
                list.add(block);
            }
            if (i > 10 && i < 13) {
                Block block = new Block(rec, Color.orange);
                list.add(block);
            }
            if (i > 12) {
                Block block = new Block(rec, Color.red);
                list.add(block);
            }
        }
        return list;
    }

    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }

    @Override
    public List<Point> ballLocation() {
        List<Point> list = new ArrayList<>();
        Point p = new Point(200, 420);
        Point p2 = new Point(230, 400);
        Point p3 = new Point(260, 380);
        Point p4 = new Point(290, 360);
        Point p5 = new Point(320, 340);
        Point p6 = new Point(400, 340);
        Point p7 = new Point(430, 360);
        Point p8 = new Point(460, 380);
        Point p9 = new Point(490, 400);
        Point p10 = new Point(520, 420);
        list.add(p);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        list.add(p10);
        return list;
    }
}
