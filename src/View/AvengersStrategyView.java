package View;

import Controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvengersStrategyView {


    public AvengersStrategyView()
    {
        JFrame f = new JFrame("Strategy View");
        f.getContentPane().setLayout(new FlowLayout());
        JButton powerStrategy=new JButton("Power Strategy");
        JButton stealthStrategy=new JButton("Stealth Strategy");
        f.getContentPane().add(powerStrategy);
        f.getContentPane().add(stealthStrategy);
        f.pack();
        f.setVisible(true);
        powerStrategy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                GameController gameController=new GameController();
                gameController.startNewGame("Power");
                f.setVisible(false);
            }
        });
        stealthStrategy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                GameController gameController=new GameController();
                gameController.startNewGame("Stealth");
                f.setVisible(false);
            }
        });
    }
}
