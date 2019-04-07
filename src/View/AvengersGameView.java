package View;

import Controller.GameController;
import Model.ModelChangeListener;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class AvengersGameView implements ModelChangeListener
{

    private GameController gameController;

    DrawingPanel panel = new DrawingPanel();

    public AvengersGameView() {
        this.gameController = new GameController();
        gameController.getGame().addModelChangedListeners(this);
        initGame();
        createAndShowGUI();
    }

    //constants and global variables
    final static Color COLOURBACK =  Color.WHITE;
    final static Color COLOURCELL =  Color.ORANGE;

    final static Color COLOURGRID =  Color.BLACK;
    final static Color COLOURONE = new Color(255,255,255,200);
    final static Color COLOURONETXT = Color.BLUE;
    final static Color COLOURTWOTXT = new Color(255,100,255);
    final static int BSIZE = 10; //board size.
    final static int HEXSIZE = 60;	//hex size in pixels
    final static int BORDERS = 10;
    final static int SCRSIZE = HEXSIZE * (BSIZE + 10) + BORDERS*3; //screen size (vertical dimension).


    void initGame(){
        hexmech.setXYasVertex(false); //RECOMMENDED: leave this as FALSE.

        hexmech.setHeight(HEXSIZE); //Either setHeight or setSize must be run to initialize the hex
        hexmech.setBorders(BORDERS);
    }

    private void createAndShowGUI()
    {
        JFrame frame = new JFrame("Avengers End Game");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container content = frame.getContentPane();
        JLabel lab1 = new JLabel("User Name", JLabel.LEFT);
        content.add(lab1);
        content.add(panel);
        frame.setSize( (int)(SCRSIZE/1.23), SCRSIZE);
        frame.setResizable(false);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
    @Override
    public void onModelChange() {
        panel.repaint();
    }

    class DrawingPanel extends JPanel
    {


        public DrawingPanel()
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
            //draw grid
            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    hexmech.drawHex(i,j,g2);
                }
            }

            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
                    hexmech.fillHex(i,j, gameController.getGame().getBoard().getHexagon(i, j), g2);
                }
            }

            hexmech.drawHex(11,16,g2);
            hexmech.modelDraw(11,6,"Player",g2);
            hexmech.drawHex(13,6,g2);
            hexmech.modelDraw(13,6,Integer.toString(gameController.getGame().getPlayerTurn()+1),g2);
            hexmech.modelDraw(15,6,"Turn",g2);

//            super.paintComponent(g2);


        }

        class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel
            public void mouseClicked(MouseEvent e) {

                Point p = new Point( hexmech.pxtoHex(e.getX(),e.getY()) );
                if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return;

                if(e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("Left Click!");
                    gameController.movePiece(p.x, p.y);
                }
                else if(e.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Right Click!");
                    gameController.attackPiece(p.x, p.y);
                }


            }
        }
    }
}