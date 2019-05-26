package View;

import Controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvengersMainView {

    public static void main(String[] args) {

        JFrame f = new JFrame("Text Field Examples");
        f.getContentPane().setLayout(new FlowLayout());
        JButton loadGame=new JButton("Load Game");
        JButton startGame=new JButton("Start New Game");
        f.getContentPane().add(loadGame);
        f.getContentPane().add(startGame);
        f.pack();
        f.setVisible(true);
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                GameController gameController=new GameController();
                gameController.loadGame();
                f.setVisible(false);
            }
        });
        startGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                AvengersStrategyView avengersStrategyView=new AvengersStrategyView();
                f.setVisible(false);
            }
        });

    }

}
