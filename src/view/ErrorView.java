package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rudolpha on 08/06/2014.
 */
public class ErrorView extends JFrame {

    JLabel errorMessage;

    public ErrorView(LanguageManager languageManager, String key){
        super(languageManager.getString("Error"));

        errorMessage= new JLabel(languageManager.getString(key));
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setVerticalAlignment(SwingConstants.CENTER);
        errorMessage.setHorizontalTextPosition(SwingConstants.CENTER);
        errorMessage.setVerticalTextPosition(SwingConstants.CENTER);


        Dimension d = new Dimension(200,200);

        getContentPane().add(errorMessage);
        setSize(d);
        setPreferredSize(d);
        setMinimumSize(d);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

}
