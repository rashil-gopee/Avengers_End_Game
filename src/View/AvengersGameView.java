package View;

import Controller.GameController;
import Model.Game;
import Interface.IModelChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.nio.file.FileSystems;


/** 
 * A utility class hexmech that gives  the ability to map clicks to a particular hexagon was adapted. 
 * This was adapted from a an open source github  here:
  * https://gist.github.com/salamander2/4329783
  */

public class AvengersGameView implements IModelChangeListener, Serializable
{
    //constants and global variables
    final static Color COLOURBACK =  Color.WHITE;
    final static Color COLOURCELL =  Color.ORANGE;

    final static Color COLOURGRID =  Color.BLACK;
    final static Color COLOURONE = new Color(255,255,255,200);
    final static Color COLOURONETXT = Color.BLUE;
    final static Color COLOURTWOTXT = new Color(255,100,255);
    final static int HEXSIZE = 60;	//hex size in pixels
    final static int BORDERS = 10;

    private GameController gameController;
    private Game game;
    private DrawingPanel panel = new DrawingPanel();
    private int screenSize;

    public AvengersGameView(Game game) {
        this.game=game;
        this.gameController = new GameController();
        gameController.registerListener(this);
        screenSize = HEXSIZE * (game.getBoardSize() + 10 ) + BORDERS*3;
        initGame();
        createAndShowGUI();
    }

    private void initGame(){
        hexmech.setXYasVertex(false); //RECOMMENDED: leave this as FALSE.
        hexmech.setHeight(HEXSIZE); //Either setHeight or setSize must be run to initialize the hex
        hexmech.setBorders(BORDERS);
    }

    private void createAndShowGUI()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu;
        JMenuItem item1 = new JMenuItem("Save");
        menu = new JMenu("File");
        menu.add(item1);
        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("hiq");
                gameController.saveGame();
            }
        });
        menuBar.add(menu);
        menu = new JMenu("Replay");
        item1 = new JMenuItem("All Moves");
        menu.add(item1);
        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameController.replayAllMoves();
            }
        });
        menuBar.add(menu);
        JFrame frame = new JFrame("Avengers End Game");
        frame.setJMenuBar(menuBar);
//        JButton b1 = new JButton("Undo");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container content = frame.getContentPane();
//        panel.add(b1);
        content.add(panel);
        frame.setSize( (int)(screenSize/1.23), screenSize);
        frame.setResizable(false);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
    @Override
    public void onModelChange(Game game) {
        this.game=game;
        panel.repaint();
    }

    private class DrawingPanel extends JPanel
    {
        private DrawingPanel()
        {
            setBackground(COLOURBACK);
            MyMouseListener ml = new MyMouseListener();
            addMouseListener(ml);
        }

        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
            g2.setColor(COLOURONETXT);
            super.paintComponent(g2);
            for (int i=0;i<game.getBoardSize();i++) {
                for (int j=0;j<game.getBoardSize();j++) {
                    hexmech.drawHex(i,j,g2);
                }
            }

            for (int i=0;i<game.getBoardSize();i++) {
                for (int j=0;j<game.getBoardSize();j++) {
                    hexmech.fillHex(i,j, game.getBoard().getHexagon(i, j), g2);
                }
            }

            hexmech.drawHex(11,16,g2);
            hexmech.modelDraw(11,6,"Player",g2);
            hexmech.drawHex(13,6,g2);
            hexmech.modelDraw(13,6,Integer.toString(game.getPlayerTurn()+1),g2);
            hexmech.modelDraw(15,6,"Turn",g2);
        }

        class MyMouseListener extends MouseAdapter	{
            public void mouseClicked(MouseEvent e) {
                System.out.println("hi");
                Point p = new Point( hexmech.pxtoHex(e.getX(),e.getY()) );
                if (p.x < 0 || p.y < 0 || p.x >= game.getBoardSize() || p.y >= game.getBoardSize()) {gameController.saveGame();}
                else {
                    if(e.getButton() == MouseEvent.BUTTON1) {
                        System.out.println("Left Click!");
                        gameController.click(p.x, p.y, false);
                    }
                    if(e.getButton() == MouseEvent.BUTTON3) {
                        gameController.click(p.x, p.y, true);
                    }
                }
            }
        }
    }
}