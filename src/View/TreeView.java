package View;
import Model.Game;

import java.awt.FlowLayout;
import javax.swing.*;

public class TreeView {

    static JTextArea textfield1;

    public TreeView()
    {
        JFrame f = new JFrame("Text Field Examples");
        f.getContentPane().setLayout(new FlowLayout());
        Game game=Game.getInstance();
        String treeRep=game.printTree();
        textfield1 = new JTextArea(treeRep);
        f.getContentPane().add(textfield1);
        f.show();
        f.pack();

    }
}
