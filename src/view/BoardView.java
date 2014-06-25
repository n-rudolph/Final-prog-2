package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rudolpha on 17/05/2014.
 */
public class BoardView extends JFrame implements Internationalizable, ActionListener{


    JPanel board;
    JPanel gameInfo;

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

    LanguageManager languageManager;

    public BoardView(LanguageManager languageManager, ActionListener newGameListener,ActionListener loadListener,
                     ActionListener saveListener,ActionListener rulesListener, ActionListener settingsListener,
                     ActionListener spanishListener, ActionListener englishListener, ActionListener exitListener) {
        super(languageManager.getString("startTitle"));
        this.languageManager=languageManager;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board=startBoard(new JPanel());
        gameInfo=new JPanel();

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

        getContentPane().add(board,BorderLayout.WEST);
        getContentPane().add(gameInfo,BorderLayout.EAST);
        Dimension d= new Dimension(650,700);
        setSize(d);
        setPreferredSize(d);
        setMinimumSize(new Dimension(600,650));
        setMaximumSize(new Dimension(750,750));
        setVisible(true);

        setLocationRelativeTo(null);
    }

    public void changeLanguage(String c, String l) {
        languageManager.changeLanguageTo(l,c);

        setTitle(languageManager.getString("newGameTitle"));

        startMenu.setText(languageManager.getString("start"));
        newGameItem.setText(languageManager.getString("newGame"));
        loadGameItem .setText(languageManager.getString("load"));
        saveGameItem .setText(languageManager.getString("save"));
        exitItem .setText(languageManager.getString("exit"));

        optionMenu.setText(languageManager.getString("settings"));
        rulesItem.setText(languageManager.getString("rules"));
        languageMenu.setText(languageManager.getString("language"));
    }

    public JPanel startBoard(JPanel panel) {

        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < 9; i++) {
            for (int j =0;j<9;j++) {
                ImageIcon image;
                if (i==0 && j ==0)
                    image = Intersection.TOP_LEFT_EMPTY.getImage();
                else if (i==0 && j==8)
                    image = Intersection.TOP_RIGTH_EMPTY.getImage();
                else if (i ==8 && j==0)
                    image = Intersection.BOTTOM_LEFT_EMPTY.getImage();
                else if (i==8 && j==8)
                    image=Intersection.BOTTOM_RIGTH_EMPTY.getImage();
                else if (i==0)
                    image = Intersection.TOP_EMPTY.getImage();
                else if (i ==8)
                    image = Intersection.BOTTOM_EMPTY.getImage();
                else if (j==0)
                    image = Intersection.LEFT_EMPTY.getImage();
                else if (j==8)
                    image = Intersection.RIGHT_EMPTY.getImage();
                else
                    image = Intersection.INTERIOR_EMPTY.getImage();
                JButton aux = new JButton(image);
                aux.setPreferredSize(new Dimension(50,50));
                aux.setMaximumSize(new Dimension(50, 50));
                aux.setMinimumSize(new Dimension(50, 50));
                aux.setBorderPainted(false);
                aux.addActionListener(new ButtonListener());
                aux.setActionCommand(Integer.toString(j) +","+ Integer.toString(i));
                c.fill=GridBagConstraints.BOTH;
                c.gridx = j;
                c.gridy = i;
                c.ipadx=0;
                c.ipady=0;
                panel.add(aux, c);
            }
        }
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command= e.getActionCommand();
        for  (int i =0;i<9;i++){
            for (int j=0;j<9;j++){
                if (command.compareTo(Integer.toString(j) +","+ Integer.toString(i))==0){

                }
            }
        }
    }

    public class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
