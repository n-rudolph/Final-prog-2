package testers;

import view.LanguageManager;
import view.SettingsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rudolpha on 08/06/2014.
 */
public class SettingsViewTester {
    private static SettingsView sv;
    private static LanguageManager languageManager;
    public static void main(String[] args) {
        languageManager= new LanguageManager() ;
        sv = new SettingsView(languageManager,new SpanishListener(), new EnglishListener(), new BackListener());

    }
    public static void changeLanguage(String l, String c){
        languageManager.changeLanguageTo(l,c);
        sv.changeLanguage(c,l);
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
    public static class BackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            changeLanguage("en", "US");
        }
    }
}
