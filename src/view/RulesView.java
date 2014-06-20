package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rudolpha on 08/06/2014.
 */
public class RulesView extends JFrame {
    JScrollPane scrollPane;
    JScrollBar scrollBar;

    JLabel rules;
    LanguageManager languageManager;

    public RulesView (LanguageManager languageManager){
        super("Rules"/*languageManager.getString("rulesTitle")*/);
        this.languageManager=languageManager;

        rules= new JLabel("akjsnalkjn");
        rules.setHorizontalAlignment(SwingConstants.CENTER);
        rules.setVerticalAlignment(SwingConstants.CENTER);
        rules.setVerticalTextPosition(SwingConstants.CENTER);
        rules.setHorizontalTextPosition(SwingConstants.CENTER);

        scrollBar= new JScrollBar();

        scrollPane= new JScrollPane();
        scrollPane.getViewport().add(rules);
        scrollPane.add(scrollBar);


        getContentPane().add(scrollPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Dimension d= new Dimension(400,500);

        setSize(d);
        setMinimumSize(d);
        setPreferredSize(d);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        RulesView rv = new RulesView(new LanguageManager());
    }
}
