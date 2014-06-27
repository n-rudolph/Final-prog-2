package view;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rudolpha on 21/05/2014.
 */
public class NewGameView extends JFrame implements Internationalizable{
    JPanel panel1;
    JPanel chooseModePanel;

    JLabel titleLabel;

    JButton twoPlayer, vsMachine, back;
    private  LanguageManager languageManager;

    public NewGameView(ActionListener twoPlayerListener, ActionListener vsMachineListener, LanguageManager languageManager,
                       ActionListener backAction) {
        super(languageManager.getString("newGameTitle"));
        this.languageManager= languageManager;
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("imagenes/Otras/newgame-image.png"))));
        setLayout(new BorderLayout());

        panel1= new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel1.setOpaque(false);

        titleLabel= new JLabel(languageManager.getString("selectMode"));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        chooseModePanel= new JPanel();
        chooseModePanel.setLayout(new BoxLayout(chooseModePanel,BoxLayout.X_AXIS));
        chooseModePanel.setOpaque(false);

        twoPlayer= new JButton("1 vs. 1");
        twoPlayer.addActionListener(twoPlayerListener);
        //twoPlayer.addActionListener(backAction);
        twoPlayer.setAlignmentY(Component.CENTER_ALIGNMENT);


        vsMachine= new JButton(languageManager.getString("vsMachine"));
        vsMachine.addActionListener(vsMachineListener);
        //vsMachine.addActionListener(backAction);
        vsMachine.setAlignmentY(Component.CENTER_ALIGNMENT);


        chooseModePanel.add(twoPlayer);
        chooseModePanel.add(Box.createHorizontalStrut(100));
        chooseModePanel.add(vsMachine);


        back = new JButton(languageManager.getString("back"));
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.addActionListener(backAction);

        panel1.add(Box.createVerticalStrut(10));
        panel1.add(titleLabel);
        panel1.add(Box.createVerticalStrut(25));
        panel1.add(chooseModePanel);
        panel1.add(Box.createVerticalStrut(30));
        panel1.add(back);

        add(panel1,BorderLayout.CENTER);


        setSize(new Dimension(325, 200));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void changeLanguage(String c, String l) {
        languageManager.changeLanguageTo(l,c);

        setTitle(languageManager.getString("newGameTitle"));
        titleLabel.setText(languageManager.getString("selectMode"));
        vsMachine.setText(languageManager.getString("vsMachine"));
        back.setText(languageManager.getString("back"));

    }



}
