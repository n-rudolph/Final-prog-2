package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rudolpha on 08/06/2014.
 */
public class SettingsView extends JFrame implements Internationalizable {

    JLabel languageLabel;
    JButton spanish, english, back;
    JPanel mainPanel, buttonPanel;

    private LanguageManager languageManager;

    public SettingsView(LanguageManager languageManager, ActionListener spanishListener, ActionListener englishListener,
                        ActionListener backListener) {

        super(languageManager.getString("settings"));
        this.languageManager=languageManager;

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        languageLabel = new JLabel(languageManager.getString("languageSelect"));
        languageLabel.setAlignmentY(CENTER_ALIGNMENT);
        languageLabel.setAlignmentX(CENTER_ALIGNMENT);

        spanish = new JButton("Español");
        spanish.addActionListener(spanishListener);
        spanish.addActionListener(new ButtonListener());

        english = new JButton("English");
        english.addActionListener(englishListener);
        english.addActionListener(new ButtonListener());

        back = new JButton(languageManager.getString("back"));
        back.addActionListener(backListener);
        back.addActionListener(new ButtonListener());
        back.setAlignmentX(CENTER_ALIGNMENT);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        buttonPanel = new JPanel();
        buttonPanel.add(spanish);
        buttonPanel.add(english);
        buttonPanel.setAlignmentY(CENTER_ALIGNMENT);
        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);

        mainPanel.add(languageLabel);
        mainPanel.add(buttonPanel);
        mainPanel.add(back);
        mainPanel.setAlignmentY(CENTER_ALIGNMENT);
        mainPanel.setAlignmentX(CENTER_ALIGNMENT);

        Dimension d = new Dimension(350, 400);

        getContentPane().add(mainPanel);
        setSize(d);
        setMinimumSize(d);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void changeLanguage(String c, String l) {
        languageManager.changeLanguageTo(l,c);
        setTitle(languageManager.getString("settings"));
        languageLabel.setText(languageManager.getString("languageSelect"));
        back.setText(languageManager.getString("back"));

    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
