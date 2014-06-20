package view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by rudolpha on 08/06/2014.
 */
public class LanguageManager {
    Locale locale;
    ResourceBundle resourceBundle;

    public LanguageManager(){
        locale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("TextBundle", locale);
    }
    public LanguageManager(String language, String country){
        changeLanguageTo(language, country);
    }

    /**
     * Returns a String in the current language specified by a key.
     * @param key Key to reference to the String.
     * @return String in the current language.
     */
    public String getString(String key){
        return resourceBundle.getString(key);
    }

    /**
     * Changes the language to the desired one.
     * @param language Language to set.
     * @param country Country to set.
     */
    public void changeLanguageTo(String language, String country){
        locale = new Locale(language, country);
        resourceBundle = ResourceBundle.getBundle("TextBundle", locale);
    }

    /**
     *
     * @return Current language.
     */
    public String getLanguage() {
        return resourceBundle.getLocale().getLanguage();
    }

    /**
     *
     * @return Current country.
     */
    public String getCountry() {
        return resourceBundle.getLocale().getCountry();
    }
}
