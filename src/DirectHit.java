import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The first level class.
 */
public class DirectHit implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        Velocity v = new Velocity(0, -4);
        list.add(v);
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
        return "Direct Hit";
    }

    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground() {
        Background back = new Background();
        back.addRec(new Rectangle(new Point(25, 25), 750, 600));
        back.recColor(Color.BLACK);
        Ball small = new Ball(new Point(400, 105), 20, Color.BLACK);
        Ball medium = new Ball(new Point(400, 105), 30, Color.BLACK);
        Ball big = new Ball(new Point(400, 105), 40, Color.BLACK);
        back.addBall(big);
        back.addBall(medium);
        back.addBall(small);
        back.ballColor(Color.blue);
        back.ballColor(Color.blue);
        back.ballColor(Color.blue);
        Line top = new Line(new Point(400, 97), new Point(400, 57));
        Line left = new Line(new Point(392, 105), new Point(352, 105));
        Line right = new Line(new Point(408, 105), new Point(448, 105));
        Line bottom = new Line(new Point(400, 113), new Point(400, 153));
        back.addLine(top);
        back.addLine(left);
        back.addLine(right);
        back.addLine(bottom);
        back.lineColor(Color.BLUE);
        back.lineColor(Color.BLUE);
        back.lineColor(Color.BLUE);
        back.lineColor(Color.BLUE);
        Ball middle = new Ball(new Point(150, 500), 50, Color.CYAN);
        Ball head = new Ball(new Point(150, 427), 25, Color.CYAN);
        Line mouth = new Line(138, 439, 162, 439);
        Ball rEye = new Ball(new Point(162, 415), 6, Color.WHITE);
        Ball lEye = new Ball(new Point(138, 415), 6, Color.WHITE);
        Ball rIshon = new Ball(new Point(162, 415), 3, Color.BLACK);
        Ball lIshon = new Ball(new Point(138, 415), 3, Color.BLACK);
        Ball leftEar = new Ball(new Point(125, 405), 10, Color.CYAN);
        Ball rightEar = new Ball(new Point(175, 405), 10, Color.CYAN);
        Ball rHand = new Ball(new Point(195, 475), 15, Color.CYAN);
        Ball lHand = new Ball(new Point(105, 475), 15, Color.CYAN);
        Ball rLeg = new Ball(new Point(195, 550), 20, Color.CYAN);
        Ball lLeg = new Ball(new Point(105, 550), 20, Color.CYAN);
        back.ballColor(Color.cyan);
        back.ballColor(Color.cyan);
        back.ballColor(Color.cyan);
        back.ballColor(Color.cyan);
        back.ballColor(Color.cyan);
        back.ballColor(Color.cyan);
        back.ballColor(Color.cyan);
        back.ballColor(Color.cyan);
        back.ballColor(Color.WHITE);
        back.ballColor(Color.WHITE);
        back.ballColor(Color.BLACK);
        back.ballColor(Color.BLACK);
        back.addBall(middle);
        back.addBall(head);
        back.addBall(rightEar);
        back.addBall(leftEar);
        back.addBall(rHand);
        back.addBall(lHand);
        back.addBall(rLeg);
        back.addBall(lLeg);
        back.addBall(rEye);
        back.addBall(lEye);
        back.addBall(rIshon);
        back.addBall(lIshon);
        back.addLine(mouth);
        back.lineColor(Color.BLACK);
        return back;
    }

    // The Blocks that make up this level, each block contains
    // its size, color and location.
    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Block b = new Block(new Rectangle(new Point(395, 100), 10, 10), Color.RED);
        list.add(b);
        return list;
    }

    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    @Override
    public List<Point> ballLocation() {
        List<Point> list = new ArrayList<>();
        Point p = new Point(400, 300);
        list.add(p);
        return list;
    }
}
