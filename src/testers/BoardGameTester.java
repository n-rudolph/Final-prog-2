package testers;

import controller.Controller;
import view.BoardView;

/**
 * Created by rudolpha on 17/05/2014.
 */
public class BoardGameTester {
    public static void main(String[] args) {
        Controller controller= new Controller();
        BoardView bv = new BoardView(controller);
    }
}
