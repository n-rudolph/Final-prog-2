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

    public NewGameView(ActionListener twoPlayerListener, ActionListener vsMachineListener, LanguageManager languageManager) {
        super(languageManager.getString("newGameTitle"));
        this.languageManager= languageManager;


        panel1= new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        chooseModePanel= new JPanel();

        titleLabel= new JLabel(languageManager.getString("selectMode"));

        twoPlayer= new JButton("1 vs. 1");
        twoPlayer.addActionListener(twoPlayerListener);
        twoPlayer.addActionListener(new ButtonListener());
        twoPlayer.setAlignmentY(Component.CENTER_ALIGNMENT);


        vsMachine= new JButton(languageManager.getString("vsMachine"));
        vsMachine.addActionListener(vsMachineListener);
        vsMachine.addActionListener(new ButtonListener());
        vsMachine.setAlignmentY(Component.CENTER_ALIGNMENT);

        chooseModePanel.add(twoPlayer);
        chooseModePanel.add(vsMachine);

        back = new JButton(languageManager.getString("back"));

        panel1.add(titleLabel);
        panel1.add(chooseModePanel);

        getContentPane().add(panel1,BorderLayout.CENTER);
        getContentPane().add(back,BorderLayout.SOUTH);

        setMinimumSize(new Dimension(450, 340));
        setSize(450, 350);
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


    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
