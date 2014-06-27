package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by rudolpha on 21/05/2014.
 */
public class StartView extends JFrame implements Internationalizable {
    JPanel startPanel;
    JButton newButton;
    JButton loadButton;
    JButton rulesButton;
    JButton optionButton;

    JMenuBar menuBar;
    JMenu startMenu;
    JMenu optionMenu;
    JMenu languageMenu;

    JMenuItem newGameItem;
    JMenuItem loadGameItem;
    JMenuItem exitItem;

    JMenuItem rulesItem;
    JMenuItem englishItem;
    JMenuItem spanishItem;

    private LanguageManager languageManager;

    public StartView(LanguageManager languageManager, ActionListener newGameListener,ActionListener loadListener,
                     ActionListener rulesListener, ActionListener settingsListener,ActionListener spanishListener,
                     ActionListener englishListener, ActionListener exitListener) {
        super(languageManager.getString("startTitle"));
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("imagenes/Otras/main-image.png"))));
        setLayout(new BorderLayout());
        this.languageManager=languageManager;

        startPanel = new JPanel();
        startPanel.setLayout(new BoxLayout(startPanel,BoxLayout.Y_AXIS));
        startPanel.setOpaque(false);

        newButton = new JButton(languageManager.getString("newGame"));
        newButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newButton.addActionListener(newGameListener);

        loadButton = new JButton(languageManager.getString("load"));
        loadButton.addActionListener(loadListener);
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        rulesButton = new JButton(languageManager.getString("rules"));
        rulesButton.addActionListener(rulesListener);
        rulesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        optionButton = new JButton(languageManager.getString("settings"));
        optionButton.addActionListener(settingsListener);
        optionButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startPanel.add(Box.createVerticalStrut(50));
        startPanel.add(newButton);
        startPanel.add(Box.createVerticalStrut(10));
        startPanel.add(optionButton);
        startPanel.add(Box.createVerticalStrut(10));
        startPanel.add(loadButton);
        startPanel.add(Box.createVerticalStrut(10));
        startPanel.add(rulesButton);

        menuBar = new JMenuBar();
        startMenu = new JMenu(languageManager.getString("start"));

        newGameItem = new JMenuItem(languageManager.getString("newGame"));
        newGameItem.addActionListener(newGameListener);
        loadGameItem = new JMenuItem(languageManager.getString("load"));
        loadGameItem.addActionListener(loadListener);
        exitItem = new JMenuItem(languageManager.getString("exit"));
        exitItem.addActionListener(exitListener);

        startMenu.add(newGameItem);
        startMenu.add(loadGameItem);
        startMenu.add(exitItem);

        optionMenu = new JMenu(languageManager.getString("settings"));
        rulesItem = new JMenuItem(languageManager.getString("rules"));
        rulesItem.addActionListener(rulesListener);
        spanishItem= new JMenuItem("Español");
        spanishItem.addActionListener(spanishListener);
        englishItem= new JMenuItem("English");
        englishItem.addActionListener(englishListener);

        languageMenu = new JMenu(languageManager.getString("language"));
        languageMenu.add(spanishItem);
        languageMenu.add(englishItem);

        optionMenu.add(rulesItem);
        optionMenu.add(languageMenu);

        menuBar.add(startMenu);
        menuBar.add(optionMenu);

        add(startPanel,BorderLayout.CENTER);
        getContentPane().add(menuBar, BorderLayout.NORTH);
        Dimension d= new Dimension(600,347);
        setSize(d);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void changeLanguage(String c, String l) {
        languageManager.changeLanguageTo(l,c);

        setTitle(languageManager.getString("startTitle"));

        newButton.setText(languageManager.getString("newGame"));
        loadButton.setText(languageManager.getString("load"));
        rulesButton .setText(languageManager.getString("rules"));
        optionButton .setText(languageManager.getString("settings"));

        startMenu.setText(languageManager.getString("start"));
        newGameItem.setText(languageManager.getString("newGame"));
        loadGameItem .setText(languageManager.getString("load"));
        exitItem .setText(languageManager.getString("exit"));

        optionMenu.setText(languageManager.getString("settings"));
        rulesItem.setText(languageManager.getString("rules"));
        languageMenu.setText(languageManager.getString("language"));
    }
}
