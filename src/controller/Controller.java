package controller;

import model.Game;
import view.*;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudolpha on 17/05/2014.
 */
public class Controller {

    private StartView sv;
    private NewGameView ngv;
    private BoardView bv;
    private SettingsView settings;
    private RulesView rv;

    private Game game;
    private LanguageManager languageManager;
    private List<Internationalizable> internationalizables;


    public Controller(){
        languageManager= new LanguageManager();
        internationalizables= new ArrayList<Internationalizable>();
        sv= new StartView(languageManager, new NewGameListener(), new LoadListener(), new SaveListener(),
                new RulesListener(),new SettingsListener(),new SpanishListener(), new EnglishListener(),
                new ExitListener());
        internationalizables.add(sv);


    }
    public void changeLanguage(String l, String c){
        languageManager.changeLanguageTo(l,c);
        for (Internationalizable internationalizable : internationalizables)
            internationalizable.changeLanguage(c, l);
    }

    public void startGame(boolean machine){
        sv.setVisible(false);
        game = new Game(machine);
        bv = new BoardView(languageManager,new NewGameListener(), new LoadListener(), new SaveListener(),
                new RulesListener(), new SpanishMenuListener(), new EnglishMenuListener(),
                new ExitListener(), new IntersectionListener());
        internationalizables.add(bv);
    }

    public class NewGameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ngv= new NewGameView(new TwoPlayerListener(), new VsMachineListener(), languageManager, new BackNewGameListener());
            internationalizables.add(ngv);
            sv.setVisible(false);
            bv.dispose();
        }
    }

    public class LoadListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class SaveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class SettingsListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            settings= new SettingsView(languageManager, new SpanishListener(), new EnglishListener(),
                    new BackSettingsListener());
            sv.setVisible(false);
        }
    }

    public class RulesListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class TwoPlayerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            startGame(false);
        }
    }

    public class VsMachineListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           startGame(true);
        }
    }

    public class SpanishListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            changeLanguage("es", "AR");
            sv.setVisible(true);
        }
    }

    public class EnglishListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            changeLanguage("en", "US");
            sv.setVisible(true);
        }
    }

    public class SpanishMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            changeLanguage("es","AR");
        }
    }

    public class EnglishMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            changeLanguage("en","US");
        }
    }

    public class ExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class BackSettingsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            settings.dispose();
            sv.setVisible(true);
        }
    }

    public class BackNewGameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ngv.dispose();
            sv.setVisible(true);
        }
    }

    public class IntersectionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command= e.getActionCommand();
            String [] coordenates=command.split(",");
            game.play(Integer.parseInt(coordenates[0]),Integer.parseInt(coordenates[1]));
            bv.changeImage(Integer.parseInt(coordenates[0]),Integer.parseInt(coordenates[1]),Intersection.TOP_LEFT_BLACK.getImage());
        }
    }
}
