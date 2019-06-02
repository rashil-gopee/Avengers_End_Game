package View;

import Controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class AvengersMainView {

    public static void main(String[] args) {

        JFrame f = new JFrame("Avengers:End Game");
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
                try {
                    gameController.loadGame();
                }
                catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "No previous saved game found! Starting a new game.");
                    new AvengersStrategyView();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                f.setVisible(false);
            }
        });
        startGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                new AvengersStrategyView();
                f.setVisible(false);
            }
        });

    }

}
