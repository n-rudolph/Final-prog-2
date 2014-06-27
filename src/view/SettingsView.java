package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

/**
 * Created by rudolpha on 08/06/2014.
 */
public class SettingsView extends JFrame implements Internationalizable {

    JLabel languageLabel;
    JButton spanish, english, back;
    JPanel mainPanel, buttonPanel;

    private LanguageManager languageManager;

    public SettingsView(LanguageManager languageManager, ActionListener spanishListener, ActionListener englishListener,
                        ActionListener backSettingsListener) {

        super(languageManager.getString("settings"));
        this.languageManager=languageManager;
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        setContentPane(new JLabel(new ImageIcon(getClass().getResource("imagenes/Otras/banderas.png"))));
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);

        languageLabel = new JLabel(languageManager.getString("languageSelect"));
        languageLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        languageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        languageLabel.setForeground(Color.BLACK);
        languageLabel.setFont(new Font("Serif",Font.BOLD,24));


        buttonPanel= new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setOpaque(false);

        spanish = new JButton("Español");
        spanish.addActionListener(spanishListener);
        spanish.addActionListener(new ButtonListener());
        spanish.setAlignmentX(Component.CENTER_ALIGNMENT);

        english = new JButton("English");
        english.addActionListener(englishListener);
        english.addActionListener(new ButtonListener());
        english.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel.add(english);
        buttonPanel.add(Box.createHorizontalStrut(100));
        buttonPanel.add(spanish);

        back = new JButton(languageManager.getString("back"));
        back.addActionListener(backSettingsListener);
        back.addActionListener(new ButtonListener());
        back.setAlignmentX(Component.CENTER_ALIGNMENT);


        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(languageLabel);
        mainPanel.add(Box.createVerticalStrut(25));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(back);

        Dimension d = new Dimension(350, 170);

        add(mainPanel,BorderLayout.CENTER);

        setSize(d);
        setResizable(false);
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
