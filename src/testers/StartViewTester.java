package testers;

import view.BoardView;
import view.LanguageManager;
import view.StartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rudolpha on 21/05/2014.
 */
public class StartViewTester {
    private static StartView sv;
    private static LanguageManager languageManager;
    public static void main(String[] args) {
        languageManager= new LanguageManager() ;
        sv = new StartView(languageManager, new NewGameListener(),
                new LoadListener(), new SaveListener(), new RulesListener(), new SettingsListener(),
                new SpanishListener(), new EnglishListener(), new ExitListener());

    }
    public static void changeLanguage(String l, String c){
        languageManager.changeLanguageTo(l,c);
        sv.changeLanguage(c,l);
    }

    public static class NewGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static class LoadListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static class SaveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static class SettingsListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static class RulesListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static class SpanishListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            changeLanguage("es", "AR");
        }
    }

    public static class EnglishListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            changeLanguage("en", "US");
        }
    }

    public static class ExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
