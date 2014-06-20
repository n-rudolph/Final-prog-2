package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rudolpha on 17/05/2014.
 */
public class BoardView extends JFrame{
    JFrame boardFrame;

    JPanel board;
    JPanel gameInfo;

    Controller controller;
    public BoardView(Controller controller) {
        this.controller=controller;

        boardFrame = new JFrame();
        boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board= new JPanel();
        board.setLayout(new GridLayout(9,9));

        for (int i =0; i<81;i++) {
            JButton aux = new JButton(Integer.toString(i));
            board.add(aux);
            //aux.setVisible(false);
        }



        gameInfo=new JPanel();
        boardFrame.getContentPane().add(board,BorderLayout.WEST);
        boardFrame.getContentPane().add(gameInfo,BorderLayout.EAST);
        boardFrame.setSize(700,700);
        boardFrame.setVisible(true);

        setLocationRelativeTo(null);
    }
}
