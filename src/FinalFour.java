import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the fourth level class.
 */
public class FinalFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        Velocity v = new Velocity(0, -3);
        list.add(v);
        Velocity v2 = new Velocity(-3, -2);
        list.add(v2);
        Velocity v3 = new Velocity(3, -2);
        list.add(v3);
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
        return "Final Four";
    }

    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground() {
        Background back = new Background();
        back.addRec(new Rectangle(new Point(25, 25), 750, 600));
        back.recColor(Color.BLUE);
        for (int i = 0; i < 11; i++) {
            Line line = new Line(95 + 8 * i, 485, 100 + 8 * i, 600);
            back.addLine(line);
            back.lineColor(Color.WHITE);
        }
        Ball ball = new Ball(new Point(100, 475), 20, Color.lightGray);
        Ball ball2 = new Ball(new Point(120, 500), 15, Color.lightGray);
        Ball ball3 = new Ball(new Point(135, 468), 28, Color.lightGray);
        Ball ball4 = new Ball(new Point(140, 485), 20, Color.lightGray);
        Ball ball5 = new Ball(new Point(160, 479), 22, Color.lightGray);
        back.addBall(ball5);
        back.addBall(ball4);
        back.addBall(ball3);
        back.addBall(ball2);
        back.addBall(ball);
        back.ballColor(Color.lightGray);
        back.ballColor(Color.lightGray);
        back.ballColor(Color.lightGray);
        back.ballColor(Color.lightGray);
        back.ballColor(Color.lightGray);
        for (int i = 0; i < 11; i++) {
            Line line = new Line(595 + 8 * i, 485, 580 + 8 * i, 600);
            back.addLine(line);
            back.lineColor(Color.WHITE);
        }
        Ball ball6 = new Ball(new Point(600, 475), 20, Color.lightGray);
        Ball ball7 = new Ball(new Point(620, 500), 15, Color.lightGray);
        Ball ball8 = new Ball(new Point(635, 468), 28, Color.lightGray);
        Ball ball9 = new Ball(new Point(640, 485), 20, Color.lightGray);
        Ball ball10 = new Ball(new Point(660, 479), 22, Color.lightGray);
        back.addBall(ball6);
        back.addBall(ball7);
        back.addBall(ball8);
        back.addBall(ball9);
        back.addBall(ball10);
        back.ballColor(Color.lightGray);
        back.ballColor(Color.lightGray);
        back.ballColor(Color.lightGray);
        back.ballColor(Color.lightGray);
        back.ballColor(Color.lightGray);
        for (int j = 0; j < 3; j++) {
            Line line = new Line(600 + j, 475, 580 + j, 510);
            Line line2 = new Line(580 + j, 510, 620 + j, 472 + 45);
            Line line3 = new Line(620 + j, 472 + 45, 602 + j, 600);
            back.lineColor(Color.YELLOW);
            back.lineColor(Color.YELLOW);
            back.lineColor(Color.YELLOW);
            back.addLine(line);
            back.addLine(line2);
            back.addLine(line3);
        }
        return back;
    }

    // The Blocks that make up this level, each block contains
    // its size, color and location.
    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                Rectangle rectangle = new Rectangle(new Point(725 - 50 * j, 100 + 30 * i), 50, 30);
                if (i == 0) {
                    Block block = new Block(rectangle, Color.darkGray);
                    list.add(block);
                }
                if (i == 1) {
                    Block block = new Block(rectangle, Color.red);
                    list.add(block);
                }
                if (i == 2) {
                    Block block = new Block(rectangle, Color.yellow);
                    list.add(block);
                }
                if (i == 3) {
                    Block block = new Block(rectangle, Color.green);
                    list.add(block);
                }
                if (i == 4) {
                    Block block = new Block(rectangle, Color.white);
                    list.add(block);
                }
                if (i == 5) {
                    Block block = new Block(rectangle, Color.pink);
                    list.add(block);
                }
                if (i == 6) {
                    Block block = new Block(rectangle, Color.cyan);
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
        return 105;
    }

    @Override
    public List<Point> ballLocation() {
        List<Point> list = new ArrayList<>();
        Point p = new Point(402, 380);
        Point p2 = new Point(322, 400);
        Point p3 = new Point(480, 400);
        list.add(p);
        list.add(p2);
        list.add(p3);
        return list;
    }
}
