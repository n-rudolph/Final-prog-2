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
    JMenuItem saveGameItem;
    JMenuItem exitItem;


    JMenuItem rulesItem;
    JMenuItem englishItem;
    JMenuItem spanishItem;


    private LanguageManager languageManager;

    public StartView(LanguageManager languageManager, ActionListener newGameListener,ActionListener loadListener,
                     ActionListener saveListener,ActionListener rulesListener, ActionListener settingsListener,
                     ActionListener spanishListener, ActionListener englishListener, ActionListener exitListener) {
        super(languageManager.getString("startTitle"));
        this.languageManager=languageManager;

        startPanel = new JPanel(new GridLayout(3, 3));

        newButton = new JButton(languageManager.getString("newGame"));
        newButton.addActionListener(newGameListener);
        loadButton = new JButton(languageManager.getString("load"));
        loadButton.addActionListener(loadListener);
        rulesButton = new JButton(languageManager.getString("rules"));
        rulesButton.addActionListener(rulesListener);
        optionButton = new JButton(languageManager.getString("settings"));
        optionButton.addActionListener(settingsListener);

        startPanel.add(newButton);
        startPanel.add(new JLabel(" "));
        startPanel.add(optionButton);
        startPanel.add(new JLabel(" "));
        startPanel.add(new JLabel(" "));
        startPanel.add(new JLabel(" "));
        startPanel.add(loadButton);
        startPanel.add(new JLabel(" "));
        startPanel.add(rulesButton);

        Dimension expectedDimension = new Dimension(400, 300);

        startPanel.setPreferredSize(expectedDimension);
        startPanel.setMaximumSize(expectedDimension);
        startPanel.setMinimumSize(expectedDimension);

        Box box = new Box(BoxLayout.Y_AXIS);

        box.add(Box.createVerticalGlue());
        box.add(startPanel);
        box.add(Box.createVerticalGlue());

        menuBar = new JMenuBar();
        startMenu = new JMenu(languageManager.getString("start"));

        newGameItem = new JMenuItem(languageManager.getString("newGame"));
        newGameItem.addActionListener(newGameListener);
        loadGameItem = new JMenuItem(languageManager.getString("load"));
        loadGameItem.addActionListener(loadListener);
        saveGameItem = new JMenuItem(languageManager.getString("save"));
        saveGameItem.addActionListener(saveListener);
        exitItem = new JMenuItem(languageManager.getString("exit"));
        exitItem.addActionListener(exitListener);

        startMenu.add(newGameItem);
        startMenu.add(loadGameItem);
        startMenu.add(saveGameItem);
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

        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(box);
        setMinimumSize(new Dimension(500, 500));
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(500, 500);
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
        saveGameItem .setText(languageManager.getString("save"));
        exitItem .setText(languageManager.getString("exit"));

        optionMenu.setText(languageManager.getString("settings"));
        rulesItem.setText(languageManager.getString("rules"));
        languageMenu.setText(languageManager.getString("language"));
    }
}
