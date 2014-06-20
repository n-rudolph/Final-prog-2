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
    private SettingsView settV;
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

    public class NewGameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ngv= new NewGameView(new TwoPlayerListener(), new VsMachineListener(), languageManager);
            internationalizables.add(ngv);
            sv.setVisible(false);
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
            settV= new SettingsView(languageManager, new SpanishListener(), new EnglishListener(),new BackListener());
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

        }
    }

    public class VsMachineListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    public class SpanishListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            changeLanguage("es", "AR");
        }
    }

    public class EnglishListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            changeLanguage("en", "US");
        }
    }

    public class ExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class BackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
