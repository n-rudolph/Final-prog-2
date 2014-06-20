package testers;

import view.LanguageManager;
import view.NewGameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rudolpha on 21/05/2014.
 */
public class NewGameViewTester {
    public static void main(String[] args) {
        NewGameView ngv = new NewGameView(new TwoPlayerListener(), new VsMachineListener(), new LanguageManager());
    }

    public static class TwoPlayerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static class VsMachineListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }
}