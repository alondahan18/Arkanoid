//215314303 Alon Dahan

import java.util.ArrayList;
import java.util.List;

/**
 * In this class we are going to run the game.
 */
public class Ass6Game {
    /**
     * main function for the class.
     *
     * @param args the main input
     */
    public static void main(String[] args) {
        List<LevelInformation> list = new ArrayList<>();
        if (args.length == 0) {
            list.add(new DirectHit());
            list.add(new WideEasy());
            list.add(new Green3());
            list.add(new FinalFour());
        } else {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1")) {
                    list.add(new DirectHit());
                }
                if (args[i].equals("2")) {
                    list.add(new WideEasy());
                }
                if (args[i].equals("3")) {
                    list.add(new Green3());
                }
                if (args[i].equals("4")) {
                    list.add(new FinalFour());
                }
            }
        }
        if (list.size() == 0) {
            list.add(new DirectHit());
            list.add(new WideEasy());
            list.add(new Green3());
            list.add(new FinalFour());
        }
        GameFlow gameFlow = new GameFlow();
        gameFlow.runLevels(list);
    }
}
